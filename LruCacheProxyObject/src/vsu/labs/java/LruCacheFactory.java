package vsu.labs.java;

abstract class LruCacheFactory<K, V> {
    abstract LruCache<K, V> createLruCache(int maxSize);
}
