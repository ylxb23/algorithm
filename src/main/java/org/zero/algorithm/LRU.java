package org.zero.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用LinkedBlockingQueue实现LRU算法缓存
 */
public class LRU extends LinkedHashMap {

    private int cap;

    public LRU(int cap) {
        this.cap = cap;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put("A", "A");
        lru.put("B", "B");
        lru.put("C", "C");
        System.out.println(lru);

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println(queue);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cap;
    }
}
