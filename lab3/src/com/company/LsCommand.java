package com.company;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class LsCommand extends Command {
    public LsCommand(Boolean key) {
        setKey(key);
    }

    @Override
    public void doTask() throws IOException {
        File f = new File(new File("").getAbsolutePath());
        ArrayList<String> a = new ArrayList<String>();
        for (File s : f.listFiles()) {
            if (s.isFile() || s.isDirectory()) {
                a.add(s.getName());
            }
        }

        if (getKey())
            for (int i = a.size() - 1; i > 0; i--) {
                System.out.println("\t" + a.get(i).toString());
            }
        else
            for (int i = 0; i < a.size(); i++) {
                System.out.println("\t" + a.get(i).toString());
            }
    }
}
