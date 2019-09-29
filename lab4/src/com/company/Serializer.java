package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serializer {
    public static Boolean Serialize(Matrix matrix) throws IOException {
       // File file = new File();
        FileWriter writer = new FileWriter(new File("").getAbsolutePath() + "\\output.txt", false);
        writer.write(matrix.getRows() + " " + matrix.getColumns() + "\n");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                writer.write(matrix.GetValue(i,j) + "\t");
            }
            writer.write("\n");
        }
        writer.flush();
        return  true;
    }
}
