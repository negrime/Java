package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        final String fileName = "task.txt";
        String formula = "";
        System.out.println("1 - Ввести формулу\n2 - Считать с файла \"task.txt\"\n3 - Сгенерировать случайную формулу");
        Scanner in = new Scanner(System.in);
        int anwser = in.nextInt();
        in.nextLine();
        switch (anwser) {
            case 1:
                System.out.println("Введите формулу:");
                formula = in.nextLine();
                in.close();
                break;
            case 2:
                System.out.println("Считываю с файла...");
                formula = ReadFromFile(fileName);
                break;
        }
        System.out.println(formula);
        System.out.println("\nОтвет: " + Task(formula));
    }


    public static String ReadFromFile(String fileName) {
        BufferedReader br;
        String result = "";
        try {
            br = new BufferedReader(new FileReader(fileName));
            result = br.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }

        return result;
    }

    public static float Task(String str) throws Exception {
        Stack<Float> numbersStack = new Stack<Float>();
        Stack<Symbol> symbolsStack = new Stack<Symbol>();
        str = DeleteGaps(str);
        float result = 0;
        int i = 0;
        String number = "";
        boolean ok = true;
        while (i < str.length()) {
            char c = GetSymbol(i, str);
            number = "";

            if (isNumber(c)) {
                while (isNumber(c) && ok) {
                    number += String.valueOf(c);
                    i++;
                    if (i < str.length()) {
                        c = GetSymbol(i, str);
                    } else
                        ok = false;
                }
                if (!number.isEmpty())
                    numbersStack.add(Float.parseFloat(number));

            } else {
                Symbol s = null;
                switch (c) {
                    case '+':
                    case '-':
                        s = new Symbol(c, 1);
                        break;
                    case '*':
                    case '/':
                        s = new Symbol(c, 2);
                        break;
                    case '(':
                    case ')':
                        s = new Symbol(c, 0);
                        break;

                    default:
                        s = new Symbol();
                }
                AddSymbol(s, symbolsStack, numbersStack);
                i++;
            }
        }
        while (!symbolsStack.isEmpty()) {
            if (symbolsStack.peek().symbol == '(' || symbolsStack.peek().symbol == ')') {
                symbolsStack.pop();
                continue;
            }
                float a = numbersStack.pop();
                float b = 0;
                if (numbersStack.size() > 0) {
                    b = numbersStack.pop();
                }
                numbersStack.add(Calculate(symbolsStack.pop(), a, b));
        }
        if (numbersStack.size() > 1) {
            throw new Exception("Неверный формат");
        }
        return numbersStack.pop();
    }


    public static String DeleteGaps(String str) {
        return str.replaceAll(" ", "");
    }

    public static char GetSymbol(int index, String str) {
        return str.charAt(index);
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void AddSymbol(Symbol sym, Stack<Symbol> symStack, Stack<Float> numStack) throws Exception {

        if (sym.isValid())
            if (symStack.isEmpty()) {
                symStack.add(sym);
            } else {
                Symbol predvSym = symStack.peek();

                if (sym.symbol == ')') {
                    while (predvSym.symbol != '(') {
                        try {
                            numStack.add(Calculate(symStack.pop(), numStack.pop(), numStack.pop()));
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        if (symStack.isEmpty()) {
                            throw new Exception("Не хватает скобки");
                        } else {
                            predvSym = symStack.peek();
                        }
                    }
                    symStack.pop();
                } else if (predvSym.priority >= sym.priority) {
                    while (!symStack.isEmpty() && (predvSym.priority >= sym.priority) && sym.symbol != '(') {
                        try {
                            numStack.add(Calculate(symStack.pop(), numStack.pop(), numStack.pop()));
                        }
                        catch (Exception e) {
                            throw new  Exception("Неверный формат формулы");
                        }
                        if (!symStack.isEmpty())
                            predvSym = symStack.peek();
                    }
                    symStack.add(sym);
                } else {
                    symStack.add(sym);
                }
            }


    }

    public static float Calculate(Symbol s, float a, float b) throws Exception {
        float result;
        switch (s.symbol) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (a == 0)
                    throw new Exception("Деление на нуль");
                result = b / a;
                break;
            default:
                result = 0;
        }
        return result;
    }
}

