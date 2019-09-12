package com.company;

import java.io.File;
import java.io.IOException;

public class EchoCommand extends Command {
    public EchoCommand(String command, String parameter) {
        setCommand(command);
        setParameter(parameter);
    }


    public void doTask() throws IOException {
        File file = new File(new File("").getAbsolutePath() + "\\" +getParameter());
        file.createNewFile();
    }
}
