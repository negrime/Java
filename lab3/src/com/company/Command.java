package com.company;

import java.io.File;
import java.io.IOException;

public abstract class Command {
    private String parameter = "";
    private boolean key = false;


    public Boolean getKey() {
        return key;
    }

    public void setKey(Boolean key) {
        this.key = key;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public abstract void doTask() throws IOException;

}
