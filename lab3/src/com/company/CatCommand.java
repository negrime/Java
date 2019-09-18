package com.company;

import java.io.*;

public class CatCommand extends Command {

    public CatCommand(String parameter) {
        setParameter(parameter);
    }

    @Override
    public void doTask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File(new File("").getAbsolutePath() + "\\" + getParameter());
        if (f.exists()) {
            BufferedReader fin = new BufferedReader(new FileReader(f));
            String line;
            System.out.println(getParameter());
            while ((line = fin.readLine()) != null)
                System.out.println("\t" + line + "\n");
        }
        else
            System.out.println("\t\"" + getParameter() + "\" does not exist!\n");
    }

}
