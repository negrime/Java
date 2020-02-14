package com.company;

import java.nio.channels.spi.AbstractSelectionKey;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите \"true\", чтобы запустить расчет в нескольких потоках");
        boolean isMultiThread = in.hasNextBoolean();
        long startTime = System.currentTimeMillis();
        System.out.println("Answer is " + new TaskManager().Task(10000000, isMultiThread));
        System.out.println("Time spend: " + (double) (System.currentTimeMillis() - startTime));

    }
}
