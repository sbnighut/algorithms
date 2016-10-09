package com.swapnil;


import apple.laf.JRSUIUtils;

// Ternary tree implementation for list of strings
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    public void add(TreeNode t) {
        int v = t.val;
        if (v < this.val) {
            if (this.left == null)
                this.left = t;
            else
                this.left.add(t);
        } else if (v > this.val) {
            if (this.right == null)
                this.right = t;
            else
                this.right.add(t);
        }
    }

    public boolean find(int searchItem) {
        if (this.val == searchItem)
            return true;
        else if (searchItem < this.val && this.left != null)
            return this.left.find(searchItem);
        else if (searchItem > this.val && this.right != null)
            return this.right.find(searchItem);
        else return false;
    }
}