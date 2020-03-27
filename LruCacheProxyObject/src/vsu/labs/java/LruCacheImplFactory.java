package vsu.labs.java;

import java.lang.reflect.Proxy;

class LruCacheImplFactory<K, V> extends LruCacheFactory<K, V> {
    @Override
    LruCache<K, V> createLruCache(int maxSize) {
        LruCache<K, V> original = new LruCacheImpl<>(maxSize);

        ClassLoader classLoader = original.getClass().getClassLoader();
        Class<?>[] interfaces = original.getClass().getInterfaces();
        LruCacheHandler<K, V> invocationHandler = new LruCacheHandler<>(original);

        return (LruCache<K, V>) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
