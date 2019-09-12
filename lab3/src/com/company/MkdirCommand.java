package com.company;

import java.io.File;

public class MkdirCommand extends Command {
    public MkdirCommand(String command, String param) {
        setCommand(command);
        setParameter(param);
    }


    public void doTask() {
        File f = new File(new File("").getAbsolutePath() + "\\" + getParameter());

            if (!f.exists())
                f.mkdir();
            else
                System.out.println("\ta Directory with the same name is exists!");
    }
}
