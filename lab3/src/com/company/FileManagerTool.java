package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileManagerTool {

    public void launch() throws Exception {
        System.out.println("\n\nWelcome to the File Manager Tool!");
        boolean isWork = true;
        while (isWork) {
            isWork = terminal();
        }

        System.out.println("See you later!");
    }

    private boolean terminal() throws IOException {
        boolean result = true;
        System.out.print("\nTerminal: ");
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
        if (str.length >= 3) {
            if (str[1].contains("\"") && str[2].contains("\"")) {
                str[1] += " " + str[2];
                str = Arrays.copyOf(str, str.length - 1);
                str[1] = str[1].replaceAll("\"", "");
            }
        }
        //Сделать отдельный метод ДуКоманд принимающий команду
        whatCommand(str);
        return result;

    }

    public void whatCommand(String[] lines) throws IOException {

        switch (lines[0]) {
            case "ls":
                if (lines.length < 3) {
                    boolean key = false;
                    LsCommand ls = new LsCommand("ls", "-r");
                    if (lines.length > 1) {
                        if (lines[1].equals("-r")) {
                            key = true;
                        } else {
                            System.out.println("Wrong key!");
                            return;
                        }
                    }
                    ls.doTask(key);
                } else
                    System.out.println("Wrong key");
                break;

            case "mkdir":
                if (lines.length < 3) {
                    MkdirCommand mk = new MkdirCommand("cd", lines[1]);
                    mk.doTask();
                } else
                    System.out.println("Wrong parameter");
                break;

            case "echo":
                EchoCommand echo = new EchoCommand("echo", "test.txt");
                echo.doTask();
                break;
            default:
                System.out.println("\tUnknown command!");
        }
    }

}
