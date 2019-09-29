package com.company;


import java.util.HashMap;

class Node<K, V> {
    K key;
    V value;
    Node prev;
    Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


public class LRUCache<K, V> implements ILRUCache {
    int capacity;
    HashMap<K, Node> map = new HashMap<K, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /*This method will delete node*/
    public void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    /*This method will make passed node as head*/
    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (end == null)
            end = head;
    }


    @Override
    public Object get(Object key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return (V) n.value;
        }
        return null;
    }

    @Override
    public void set(Object key, Object value) {
        if (map.containsKey(key)) {
            // update the old value
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {

                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newNode);

            } else {
                setHead(newNode);
            }

            map.put((K) key, newNode);
        }
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getLimit() {
        return 0;
    }
}