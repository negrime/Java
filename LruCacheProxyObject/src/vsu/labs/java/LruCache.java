package vsu.labs.java;

public interface LruCache<K, V> {
    V get(K key);
    void set(K key, V value);
    LruCacheImpl.Node<K, V> getLeastRecentlyUsed();
    LruCacheImpl.Node<K, V> getMostRecentlyUsed();
    int getSize();
    int getLimit();
    void print();
}
