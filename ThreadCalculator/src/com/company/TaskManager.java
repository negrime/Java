package com.company;

import java.util.ArrayList;
import java.util.Random;

public class TaskManager {

    public float Task(int count, boolean isMulti) throws Exception {
        final int threadsCount = 4;
        final int DIVIDE = 10;
        float result = 0;
        int iterations = 0;
        StringBuilder expression = new StringBuilder();
        Random random = new Random();
        System.out.println("Start generate!");
        while (iterations < DIVIDE) {
            iterations++;
            if (isMulti) {
                int expressionCount = (count / DIVIDE) / threadsCount;
                GenerateThread[] generateThreads = new GenerateThread[threadsCount];
                Thread[] threads = new Thread[threadsCount];

                for (int i = 0; i < threadsCount; i++) {
                    generateThreads[i] = new GenerateThread(expressionCount, Integer.toString(i));
                    threads[i] = new Thread(generateThreads[i]);
                    threads[i].start();
                }

                for (int i = 0; i < threadsCount; i++) {
                    threads[i].join();
                }

                for (int i = 0; i < threadsCount; i++) {
                    if (i != 0) {
                        String symbol = random.nextBoolean() ? "+" : "-";
                        expression.append(symbol + generateThreads[i].GetResult());
                    } else {
                        expression.append(generateThreads[i].GetResult());
                    }
                }
            } else {
                expression.append(ArithmeticExpressionGenerator.GenerateExpression(count, Thread.currentThread().getName()));
            }
        }
        System.out.println("Generated!");
        result += Calculate.Task(expression.toString());
        return result;
    }
}
