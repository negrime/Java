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

        r.add(100);
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(4);
        r.add(5);
        System.out.println(r.poll());
        System.out.println(r.poll());
        r.add(7);
        r.poll();
        r.poll();
        for(Integer el : r) {
            System.out.println(el);
        }

    }
}
