package org.zonghan.y2022;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache c = new LRUCache(7);
        c.put(1, 10);
        c.put(2, 20);
        c.put(3, 30);
        c.put(4, 40);
        c.put(5, 50);
        c.put(6, 60);
        c.put(7, 70);
        c.get(1);
        c.put(8, 80);

        System.out.println(c.get(1));
        System.out.println(c.get(2));
    }
}
