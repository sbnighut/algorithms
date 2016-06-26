package com.swapnil;


import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
    public static void main(String[] args) {
//        linkedListImplementation();
//        BinaryTreeImplementation();
        MergeSortImplementation();
    }

    static  void MergeSortImplementation(){
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MergeSort m =  new MergeSort(array);
    }

    static void GraphImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void HeapImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void BalancedTreeImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void BinaryTreeImplementation() {
        TreeNode tree = new TreeNode(1,0);
        tree.add(-34,0);
        tree.add(2,0);
        tree.add(76,0);
        tree.add(56,0);
        tree.add(44,0);
        tree.add(76,0);
        tree.add(3,0);
        tree.add(67,0);
        tree.add(55,0);
        tree.add(8,0);
        tree.add(32,0);
        tree.add(33,0);
        tree.add(22,0);
        tree.add(11,0);
        LinkedList<TreeNode> xyz = new LinkedList<TreeNode>();
        LinkedList<TreeNode> xyz2 = new LinkedList<TreeNode>();
        xyz.add(tree);
        xyz2.add(tree);
        int currentLevel = -1;
        tree.PrintInQueue(xyz,xyz2);
        while (xyz.isEmpty() == false) {
            if(currentLevel != xyz.get(0).level){
                currentLevel = xyz.get(0).level;
                System.out.print("\nLevel "+currentLevel+": ");
                while(xyz.isEmpty()==false && xyz.get(0).level == currentLevel){
                    System.out.print(" "+ xyz.get(0).value +" ");
                    xyz.remove(0);
                }
            }
        }
        System.out.print("The number 55's presence in tree is :" + tree.find(58));
    }

    static void DictionaryImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void HashTableImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void HashSetImplementation() {
        INode first = new Node(22);
        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());
    }

    static void linkedListImplementation() {
        INode first = new Node(22);
        first.add(33);
        first.add(33);
        first.add(44);
        first.add(44);
        first.add(44);
        first.add(55);
        first.add(55);
        first.add(55);
        first.add(55);
        first.add(66);
        first.add(66);
        first.add(66);
        first.add(77);

        System.out.print("The number of occurences of number 55 is :" + first.find(55, -1).toString());


    }
}
