package com.swapnil;

import java.util.*;

public class Node extends INode {
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public void add(int v) {
        Node obj = this;
        while(obj.next != null){
            obj = (Node)obj.next;
        }
        Node n = new Node(v);
        obj.next = n;
    }

    public List<Integer> find(int searchItem, int index) {
        if (this.value == searchItem) {
            if (this.next == null) {
                List<Integer> x = new LinkedList<Integer>();
                x.add(index + 1);
                return x;
            } else {
                List<Integer> y = ((Node) this.next).find(searchItem, index + 1);
                y.add(index + 1);
                return y;
            }
        } else {
            if (this.next != null)
                return ((Node) this.next).find(searchItem, index + 1);
            return new LinkedList<Integer>();
        }
    }
}
