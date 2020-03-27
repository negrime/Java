package vsu.labs.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LruCacheHandler<K, V> implements InvocationHandler {

    private final LruCache<K, V> cache;
    private LruCacheImpl<K, V> history;

    LruCacheHandler(LruCache<K, V> cache) {
        this.cache = cache;
        history = new LruCacheImpl<>(10);
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long startTime = System.nanoTime();
        Object result;
        switch(method.getName()) {
            case "set": {
                if (cache.getLimit() == cache.getSize())
                    System.out.println("Deleted value: " + cache.getLeastRecentlyUsed().value);
                result = method.invoke(cache, args);
                break;
            }
            case "get": {
                result = method.invoke(cache, args);
                history.set((K) args[0], (V) result);
                history.print();
                break;
            }
            default: result = method.invoke(cache, args);
        }
        long finishTime = System.nanoTime();
        System.out.println("Operation time: " + (finishTime - startTime) + " ns");
        return result;
    }

}
