package com.company;

public class Main {

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(4);
        lrucache.set(1, 100); // Добавили, является head and end
        System.out.println(lrucache.getSize()); // размерность 1

        lrucache.set(10, 99); // Добавили, является head
        lrucache.set(15, 98); // Добавили, является head

        lrucache.set(1, 97); // Затираем прошлое значение [100], теперь это head, end = [10, 99]
        System.out.println(lrucache.getSize()); // размерность 3

        lrucache.set(12, 96); // Добавляем 4тый ключ теперь он head
        System.out.println(lrucache.getSize()); // размерность 4

        lrucache.set(18, 95); // Добавляем 5тый, избавляемся от самого старого => [10, 99] + теперь это head
        System.out.println(lrucache.getSize()); // размерность 4

        lrucache.set(1, 94); // заменяем старое значение на 94 и теперь это head

        System.out.println(lrucache.get(1)); // 94
        System.out.println(lrucache.get(10)); // null
        System.out.println(lrucache.get(12)); // 96
        System.out.println(lrucache.get(15)); // 98
        System.out.println(lrucache.getCapacity());

    }
}
