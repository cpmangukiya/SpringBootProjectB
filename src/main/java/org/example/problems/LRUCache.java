package org.example.problems;

import java.util.*;
import java.util.stream.Collectors;

public class LRUCache {

    private final LinkedHashSet<Integer> linkedHashSet;
    private final int capacity;


    public LRUCache(int capacity) {
        this.linkedHashSet = new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }

    public void refer(int page){
        if(linkedHashSet.contains(page)) {
            linkedHashSet.remove(page);
            linkedHashSet.add(page);
        } else {
            if(linkedHashSet.size() >= capacity) {
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            linkedHashSet.add(page);
        }
    }

    public void display(){
        ListIterator<Integer> listIterator = new ArrayList<>(linkedHashSet).listIterator(linkedHashSet.size());
        while(listIterator.hasPrevious()) { System.out.print(listIterator.previous()+" "); }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.display();
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.refer(5);
        lruCache.display();
        System.out.println();
        LRUCache cache = new LRUCache(4);
        cache.display();
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.display();
    }


}
