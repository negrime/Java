package com.company;

import java.util.Random;

public class ArithmeticExpressionGenerator {

    public static String GenerateExpression(int count, String name) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        int halfCount = count / 2;
        for (int i = 0; i < halfCount; i++) {
            if (i != 0) {
                result.append(random.nextInt(2) % 2 == 0 ? "+" : "-");
            }
            result.append(random.nextInt(101));
            result.append(random.nextInt(2) % 2 == 0 ? "+" : "-");
            result.append(random.nextInt(101));
            // System.out.println("Generate " + (i) + " by " + name);
        }
        return result.toString();
    }
}

