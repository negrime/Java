package com.company;

public class RingBuffer<E> implements IRingBuffer<E> {
    private int size;
    private E[] array; // выполнится до конструктора? - Да

    public RingBuffer(int size) throws Exception {
        if (size < 1)
            throw new Exception("Размер очереди должен быть больше нуля");
        this.size = size;
        array = (E[]) new Object[size];
    }

    public RingBuffer() {
        size = 5;
        array = (E[]) new Object[size];
    }

    @Override
    public E poll() {
        E result = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        return result;
    }

    @Override
    public E peek() {
        return array[0];
    }

    @Override
    public void add(E item) {
        int i = 0;
        if (array[size - 1] == null)
            while (array[i] != null) {
                i++;
            }
        else {
            i = 0;
        }
        array[i] = item;
    }

    @Override
    public int getSize() {
        return size;
    }
}
