package com.swapnil;


import java.util.List;

public abstract class INode {
    public int value;
    INode next;
    INode prev;

    abstract void add(int val);
    abstract List<Integer> find(int searchItem, int index);
}
