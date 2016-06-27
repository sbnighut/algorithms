package com.swapnil;


import java.util.Arrays;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
    public static void main(String[] args) {
//        linkedListImplementation();
//        BinaryTreeImplementation();
//        MergeSortImplementation();
//        Problem1(3456);
//        Problem2("abcc");
//        Problem3(new int[]{1, 2, 3, 4});
        Problem4("hey","sam","");
    }


    //    # take an array and print non over lapping in order pairs. example:
//
//
//            # [1,2,3,4] => input
//
//    # output below is in order combination
//
//    # (1234)
//    # (1)(234)
//    # (1)(23)(4)
//    # (1)(2)(34)
//    # (12)(34)
//    # (12)(3)(4)
//    # (123)(4)
//    # (1)(2)(3)(4)
    static void Problem3(int[] arr) {
        boolean[] walls = new boolean[arr.length - 1];
        for (int x = 0; x < Math.pow(2, arr.length - 1) - 1; x++) {
            for (int i = 0; i < walls.length; i++) {
                walls[walls.length - i - 1] = (x & (1 << i)) != 0;
            }
            printComb(walls, arr);
        }
    }

    //    given 2 strings A and B. generate all possible solutions when B is merged in A.
//    Ex: A = "hey"
//    B: "sam"
    static void Problem4(String a, String b, String tillNow) {
        if (a.length() == 0 && b.length() == 0)
            System.out.println(tillNow);

        else if (a.length() == 0 && b.length() != 0)
            Problem4(a, b.substring(1), tillNow + b.charAt(0));

        else if (a.length() > 0 && b.length() == 0)
            Problem4(a.substring(1), b, tillNow + a.charAt(0));

        else {
            Problem4(a, b.substring(1), tillNow + b.charAt(0));
            Problem4(a.substring(1), b, tillNow + a.charAt(0));
        }
    }

    static void printComb(boolean[] walls, int[] arr) {
        int index = 0;
        System.out.print("\n(" + arr[index++]);
        while (index <= walls.length) {
            if (walls[index - 1] == true) {
                System.out.print(")(" + arr[index++]);
            } else {
                System.out.print(arr[index++]);
            }
        }
        System.out.print(")");
    }

    // int to int array
    static void Problem1(int x) {
        char[] input = new char[10];
        int modValue = 10;
        for (int i = 0; i < 130; i++) {
            System.out.println("Ascii value of " + (char) i + " : " + i);
        }
        for (int i = 9; i > -1; i--) {
            int z = ((x % modValue) * 10 / modValue);
            input[i] = (char) (z + 48);
            modValue *= 10;
        }
        System.out.println("The string value of number is:" + Arrays.toString(input));
    }

    static void Problem2(String s) {
        Permutation(new StringBuffer(""), new StringBuffer(s));
    }

    static void Permutation(StringBuffer left, StringBuffer right) {
        if (right.length() == 1)
            System.out.println(left.toString() + right.toString());
        else {
            for (int i = 0; i < right.length(); i++) {
                Swap(right, 0, i);
                Permutation(new StringBuffer(left.toString() + right.charAt(0)),
                        new StringBuffer(right.substring(1)));
            }
        }
    }

    static void Swap(StringBuffer s, int i, int j) {
        char c = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, c);
    }


    static void MergeSortImplementation() {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MergeSort m = new MergeSort(array);
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
        TreeNode tree = new TreeNode(1, 0);
        tree.add(-34, 0);
        tree.add(2, 0);
        tree.add(76, 0);
        tree.add(56, 0);
        tree.add(44, 0);
        tree.add(76, 0);
        tree.add(3, 0);
        tree.add(67, 0);
        tree.add(55, 0);
        tree.add(8, 0);
        tree.add(32, 0);
        tree.add(33, 0);
        tree.add(22, 0);
        tree.add(11, 0);
        LinkedList<TreeNode> xyz = new LinkedList<TreeNode>();
        LinkedList<TreeNode> xyz2 = new LinkedList<TreeNode>();
        xyz.add(tree);
        xyz2.add(tree);
        int currentLevel = -1;
        tree.PrintInQueue(xyz, xyz2);
        while (xyz.isEmpty() == false) {
            if (currentLevel != xyz.get(0).level) {
                currentLevel = xyz.get(0).level;
                System.out.print("\nLevel " + currentLevel + ": ");
                while (xyz.isEmpty() == false && xyz.get(0).level == currentLevel) {
                    System.out.print(" " + xyz.get(0).value + " ");
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
