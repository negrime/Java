package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EchoCommand extends Command {
    private String text;
    public EchoCommand(String text, String parameter) {
        setParameter(parameter);
        this.text = text;
    }

    public void doTask() throws IOException {
        File file = new File(new File("").getAbsolutePath() + "\\" +getParameter());
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("\t\"" + getParameter() + "\" was created!");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file);
                fr.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else
            System.out.println("\tFile with same name is exists!");
    }

}
