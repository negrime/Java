package com.company;

public class FormulaGenerator {
    private enum Symbols {
        Plus, Substraction, Multiplication, Division
    }
    public static String Spawn() {

        String result = "";
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                result += Math.random() * 9;
            } else {
                result += GetSymbol();
            }
        }

        return result;
    }

    private static String GetSymbol() {
        Symbols s;
   //     int rndNum = (int) Math.random());

          //      switch ()) {
           //case :

     //  }
        return "kek";
    }

}
