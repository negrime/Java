package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Matrix a;
        Matrix b = new Matrix(2, 3);
        final String firstMatrixFile = "firstMatrix.txt";
        final String secondMatrixFile = "secondMatrix.txt";
        try {
            a = Deserializer.Deserialize(firstMatrixFile);
            b = Deserializer.Deserialize(secondMatrixFile);
            System.out.println("First matrix: ");
            a.Print();
            System.out.println("Second matrix: ");
            b.Print();
            System.out.println("Multiply matrix: ");
            Matrix result = a.Multiply(b);
            result.Print();
            Serializer.Serialize(result);


        } catch (Exception e) {
            System.err.println(e);
        }

/*
        a.Generate();
        b.Generate();
        Matrix res = a.Multiply(b);
        res.Print();*/
    }
}
