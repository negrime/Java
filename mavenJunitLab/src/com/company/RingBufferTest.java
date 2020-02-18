package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RingBufferTest {

        RingBuffer<Integer> r = new RingBuffer<Integer>();

    @Test
    public void poll() {
        r.add(100);
        r.add(1);
        r.add(2);
        assertEquals(100, r.poll().intValue());
        assertEquals(1, r.poll().intValue());
    }

    @Test
    public void peek() {
        r.add(100);
        r.add(1);
        r.add(2);
        assertEquals(100, r.peek().intValue());
    }

    @Test
    public void add() {
        assertEquals(0,r.count);
        r.add(100);
        r.add(1);
        r.add(2);
        assertEquals(3,r.count);
        r.add(3);
        r.add(4);
        assertEquals(5,r.count);
        r.add(5); // Добавляем вместо 100
        assertEquals(5,r.count);

    }

    @Test
    public void getSize() {
        assertEquals(5, r.getSize());
    }

}