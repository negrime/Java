package com.company;

public class Main {

    public static void main(String[] args) {
        FileManagerTool fmn = new FileManagerTool();
        try {
            fmn.launch();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
