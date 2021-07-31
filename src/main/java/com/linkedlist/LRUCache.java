package com.linkedlist;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    Map<Integer,Integer> map = new LinkedHashMap<> ();
    int capacity;
    public LRUCache(int capacity) {
       this.capacity = capacity;
    }

    public int get(int key) {
        int value=-1;
        if(map.containsKey (key)){
           value = map.get (key);
           map.remove (key);
           map.put (key,value);
        }
       return value;
    }

    public void put(int key, int value) {
        if(map.size () == capacity){
            if(map.containsKey (key)) {
                map.remove (key);
            }else{
                map.remove (map.entrySet ().iterator ().next ().getKey ());
            }
        }
        map.put (key,value);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache (2);
        System.out.println (lruCache.get(2));
        lruCache.put (2,6);
        System.out.println (lruCache.get(1));
        lruCache.put (1,5);
        lruCache.put (1,2);
        System.out.println (lruCache.get(1));
        System.out.println (lruCache.get(2));
    }
}
