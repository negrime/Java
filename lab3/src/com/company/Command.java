package com.company;

import java.io.File;
import java.io.IOException;

public abstract class Command {
    private String command = "";
    private String parameter = "";
    private String key = "";



    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void doTask() throws IOException { System.out.println("Default");};

}
