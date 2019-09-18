package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileManagerTool {

    public void launch() throws Exception {
        System.out.println("\n\nWelcome to the File Manager Tool!");
       // while (true) {
            terminal();
        //}
        System.out.println("See you later!");
    }

    private void terminal() throws Exception {
        System.out.print("\nTerminal: ");
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");

        whatCommand(str);
    }

    public String help() {
        String result = "";
        return result;
    }

    public void whatCommand(String[] lines) throws Exception {

        switch (lines[0]) {
            case "ls":
                if (lines.length < 3) {
                    boolean key = false;
                    if (lines.length > 1) {
                        if (lines[1].equals("-r")) {
                            key = true;
                        } else {
                            System.out.println("\tWrong key!");
                            return;
                        }
                    }
                    LsCommand ls = new LsCommand(key);
                    ls.doTask();
                } else
                    System.out.println("\tWrong key!");
                break;
// тестирование дот ком
            case "mkdir":
                if (lines.length == 2) {
                    if (!lines[1].contains("\"")) {
                        MkdirCommand mk = new MkdirCommand(lines[1]);
                        mk.doTask();
                    } else {
                        System.out.println("\tSet name for directory with out \" symbols");
                    }
                } else if (lines.length > 1 && lines[1].contains("\"") && lines[lines.length - 1].contains("\"")) {
                    lines[1] = lines[1].replace("\"", "");
                    int index = findSign("\"", lines, 1);
                    if (index != -1) {
                        lines[index] = lines[index].replaceAll("\"", "");
                        MkdirCommand mk = new MkdirCommand(lines[index]);
                        mk.doTask();
                    } else {
                        System.out.println("\t\" missed");
                    }
                } else
                    System.out.println("\tWrong parameter!");
                break;

            case "echo":
                if (lines.length >= 3 && lines[1].contains("\"")) {
                    EchoCommand echo;
                    lines[1] = lines[1].replace("\"", "");
                    int index = findSign("\"", lines, 1);
                    if (index != -1) {
                        lines[index] = lines[index].replaceAll("\"", "");
                        String text = lines[index];

                        if (lines.length - 1 == index + 1 && lines[index + 1].contains(".txt")) {
                            echo = new EchoCommand(text, lines[index + 1]);
                            echo.doTask();
                        } else if (lines[++index].contains("\"")) {
                            lines[index] = lines[index].replace("\"", "");
                            index = findSign(".txt\"", lines, index);
                            if (index != -1) {
                                lines[index] = lines[index].replaceAll("\"", "");
                                echo = new EchoCommand(text, lines[index]);
                                echo.doTask();
                            }
                        } else {
                            System.out.println("\tWrong second parameter!");
                        }
                    } else {
                        System.out.println("\tWrong first parameter!");
                    }
                } else {
                    System.out.println("\tWrong parameter!");
                }
                break;
            case "cat":
                if (lines.length >= 2) {
                    int index = 1;
                    CatCommand cat = new CatCommand(lines[1]);
                    while (index < lines.length) {
                        if (lines[index].contains(".txt")) {
                            if (lines[index].contains("\""))
                                lines[index] = lines[index].replaceAll("\"", "");
                            cat.setParameter(lines[index]);
                            cat.doTask();
                        } else if (lines[index].contains("\"")) {
                            int kek = lines[index].indexOf("\"");
                            lines[index] = lines[index].substring(lines[index].indexOf("\"") + 1);

                            index = findSign("\"", lines, index);

                            if (index != -1) {
                                String file = lines[index].replaceAll("\"", "");
                                cat.setParameter(file);
                                cat.doTask();
                            } else {
                                System.out.println("\tWrong parameters!");
                            }

                        } else {
                            System.out.println("\tWrong parameter! - " + lines[index] + "\n");
                            return;
                        }

                        index++;
                    }

                }
                break;
            default:
                System.out.println("\tUnknown command!");
        }

    }


    public Integer findSign(String c, String[] arr, int index) {
        boolean ok = false;
        String str = "";
        while (index < arr.length) {
            str += arr[index];
            if (arr[index].contains(c)) {
                arr[index] = str;
                return index;
            }
            str += " ";
            index++;
        }
        return -1;
    }
}
