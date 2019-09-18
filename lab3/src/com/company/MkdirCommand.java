package com.company;

import java.io.File;

public class MkdirCommand extends Command {
    public MkdirCommand(String param) {
        setParameter(param);
    }


    public void doTask() {
        File f = new File(new File("").getAbsolutePath() + "\\" + getParameter());

        if (!f.exists()) {
            f.mkdir();
            System.out.println("\t\"" + getParameter() + "\" was created!");
            System.out.println(f.getPath());
        }
        else
            System.out.println("\ta Directory with the same name is exists!");
    }
}
