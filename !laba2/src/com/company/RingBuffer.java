package com.company;

import java.util.Iterator;
public class RingBuffer<E> implements IRingBuffer<E> {
    private int size;
    private E[] array; // выполнится до конструктора? - Да
    private int head = 0;
    public int count = 0;
    private int tail = 0;

    public RingBuffer(int size) throws Exception {
        if (size < 2) {
            throw new Exception("Размер очереди должен быть больше единицы");
        }
        this.size = size;
        array = (E[]) new Object[size];
    }

    public RingBuffer() {
        size = 5;
        array = (E[]) new Object[size];
    }

    @Override
    public E poll() {
        E result = array[head];
        array[head] = null;
        head++;
        if (head % size == 0) {
            head = 0;
        }
        count--;
        return result;
    }

    @Override
    public E peek() {
        return array[head];
    }

    @Override
    public void add(E item) {
        count++;
        array[tail] = item;
        tail++;
        if ((tail % (size)) == 0) {
            count--;
            tail = 0;
            if (head == 0) {
                head++;
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int curCount = count;
            private int curIndex = head;
            @Override
            public boolean hasNext() {
                return curCount != 0;
            }

            @Override
            public E next() {
                --curCount;
                if (curIndex == size) {
                    curIndex = 0;
                }
                return array[curIndex++];
            }
        };

        return it;
    }
}
