package com.swapnil;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ternary tree implementation for list of strings
public class TreeNode {
    public int value, level;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, int l) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.level = l;
    }

    public void PrintInQueue(LinkedList<TreeNode> que, LinkedList<TreeNode> que2) {
        if (que2.isEmpty() == false) {
            TreeNode x = que2.remove(0);
            if (x.left != null) {
                que.add(x.left);
                que2.add(x.left);
            }
            if (x.right != null) {
                que.add(x.right);
                que2.add(x.right);
            }
            x.PrintInQueue(que, que2);
        }
    }

    public void add(int v, int l) {
        if (v < this.value) {
            if (this.left == null)
                this.left = new TreeNode(v, l+1);
            else
                this.left.add(v, l+1);
        } else if (v > this.value) {
            if (this.right == null)
                this.right = new TreeNode(v,l+1);
            else
                this.right.add(v, l+1);
        }
    }

    public boolean find(int searchItem) {
        if (this.value == searchItem)
            return true;
        else if (searchItem < this.value && this.left != null)
            return this.left.find(searchItem);
        else if (searchItem > this.value && this.right != null)
            return this.right.find(searchItem);
        else return false;
    }
}