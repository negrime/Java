package com.company;

import java.io.*;

public class Deserializer {
    public static Matrix Deserialize(String fileName) throws Exception {
        File file = new File(new File("").getAbsolutePath() + "\\" + fileName);
        BufferedReader fin = new BufferedReader(new FileReader(file));
        Matrix result = null;
        result = setSize(fin, file);
        if ( result != null) {
            String[] s;
            String st = "";
            String line= "";
            for (int i = 0; i < result.getRows(); i++ ) {
                st +=  fin.readLine();
            }
            s = st.replaceAll("[\\s]{2,}", " ").split(" ");
            try {
                fillMatrix(result, s);
            }
            catch (Exception e) {
                System.out.print(e);
            }
        }
        return result;
    }

    private static Matrix setSize(BufferedReader fin, File file) throws IOException {
        String line;
        Matrix result = null;
        line = fin.readLine();
        if (line != null) {
            String[] str = line.replaceAll("[\\s]{2,}", " ").split(" ");

            if (str.length == 2) {
                result = new Matrix(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }
        }
        return result;
    }

    private static void fillMatrix(Matrix matrix, String[] strings) {
        int sIndex = -1;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.SetValue(i, j, Float.parseFloat(strings[++sIndex]));
            }
        }
    }
}
