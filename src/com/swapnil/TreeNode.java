package com.swapnil;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ternary tree implementation for list of strings
public class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode mid;

    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.mid = null;
    }

    public void PrintInQueue(Queue<String> que) {
        if(left != null)
            que.add(left.value);
        if(mid != null)
            que.add(mid.value);
        if(right != null)
            que.add(right.value);
    }

    public void add(String v) {
        TreeNode obj = this;
        while (obj.left != null) {
            obj = (TreeNode) obj.left;
        }
        TreeNode n = new TreeNode(v);
        obj.left = n;
    }

    public List<Integer> find(String searchItem, int level) {
        if (this.value == searchItem) {
            if (this.left == null) {
                List<Integer> x = new LinkedList<Integer>();
                x.add(level + 1);
                return x;
            } else {
                List<Integer> y = ((TreeNode) this.left).find(searchItem, level + 1);
                y.add(level + 1);
                return y;
            }
        } else {
            if (this.left != null)
                return ((TreeNode) this.left).find(searchItem, level + 1);
            return new LinkedList<Integer>();
        }
    }
}

