package com.company;


public class Main {

    public static void main(String[] args) {
        RingBuffer<Integer> r = null;
        try {
             r = new RingBuffer();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(r.getSize());
        System.out.println(r.poll());
        r.add(100);
        System.out.println(r.poll());
        System.out.println(r.peek());
        r.add(1);
        System.out.println(r.peek());
        r.add(2);
        r.add(3);
        r.add(4);
        r.add(5);
        r.add(6); // Затираем единицу
        System.out.println(r.peek());
    }
}
