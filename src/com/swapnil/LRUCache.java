package com.swapnil;

import java.util.*;

public class LRUCache {
    Node head;
    Node tail;
    static Map<Integer, Node> m;
    static List<Node> list;
    public LRUCache(int capacity) {
        m = new HashMap<Integer, Node>();
        list = new LinkedList<Node>();
        head = new Node(-1);
        tail = head;
        head.next = null;
        head.prev = null;
    }

    public int get(Integer key) {
        if(m.containsKey(key)){
            Node i = m.get(key);
            i.next.prev = i.prev;
            i.prev.next = i.next;
            i.next = head;
            head.prev = i;
            head = i;
            return i.value;
        }
        return -1;
    }

    public void set(Integer key, Node value) {
        if(m.containsKey(key)){
            Node i = m.get(key);
            i.next.prev = i.prev;
            i.prev.next = i.next;
            i.next = head;
            head.prev = i;
            head = i;
        }
        else {
            m.put(key, value);
        }
    }
}