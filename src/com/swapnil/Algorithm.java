package com.swapnil;


import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.*;
import java.util.stream.IntStream;




public class Algorithm {
    public static void main(String[] args) {
        //        linkedListImplementation();
        //        BinaryTreeImplementation();
        //        MergeSortImplementation();
        //        Problem1(3456);
        //        Problem2("abcc");
        //        Problem3(new int[]{1, 2, 3, 4});
        //        Problem4("hey","sam","");
        //        TokenizerProblem("He isn't a good man");
        //HashMapImplementation();
        //PatternChecker("[AZ[a-z](a-z)");

        //        movePlane("7U3DX2D");
        //int[] z = twoSum(new int[]{3,2,4},6);

        threeSum(new int[]{2,5,-7, 3, -5});
    }

    static List<List<Integer>> set;
    static List<List<Integer>> threeSum(int[] nums) {
        set = new LinkedList<List<Integer>>();
        addThree(nums, 0, 1, 2, 0);
        return set;
    }

    static void addThree(int[] nums,int i, int j, int k, int target){
        if(i< j && j <k && k<nums.length) {
            if ((nums[i] + nums[j] + nums[k]) == target)
                set.add((Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]})));
            addThree(nums, i+1, j, k, target);
            addThree(nums, i, j+1, k, target);
            addThree(nums, i, j, k+1, target);
        }
    }

    static int[] twoSum(int[] nums, int target){
        List<Integer> result = new LinkedList<Integer>();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>() ;
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], i);
        }

        for(int i=0;i<=nums.length/2;i++){
            if(m.containsKey(nums[i]) && m.containsKey(target - nums[i]) && nums[i] != target/2){
                result.add(m.get(nums[i]));
                result.add(m.get(target - nums[i]));
            }
        }
        return result.stream().mapToInt(k->k).toArray();
    }

    static String movePlane(String command) {
        List<Command> commands = new LinkedList<Command>();
        int cmdCount = 0;
        int nextInt = 0;
        int decimalPlaces = 0;
        for(int i = 0;i<command.length(); i++){
            char ch = command.charAt(i);
            nextInt = Character.getNumericValue(ch);
            if(nextInt > -1 && nextInt <10){
                cmdCount = cmdCount*10 + nextInt;
                decimalPlaces++;
            }
            else{
                if(cmdCount == 0)
                    cmdCount = 1;
                switch(ch){
                    case 'D':
                        commands.add(new Command(cmdCount, CommandType.D));
                        break;
                    case 'U':
                        commands.add(new Command(cmdCount, CommandType.U));
                        break;
                    case 'L':
                        commands.add(new Command(cmdCount, CommandType.L));
                        break;
                    case 'R':
                        commands.add(new Command(cmdCount, CommandType.R));
                        break;
                    case 'X':
                        if(commands.size() > cmdCount){
                            int j = cmdCount;
                            while(j > 0){
                                commands.remove(commands.size()-1);
                                j--;
                            }
                        }
                        else
                            commands = new LinkedList<Command>();
                        break;
                    default:
                        break;

                }
                nextInt = 0;
                cmdCount = 0;
                decimalPlaces = 0;

            }
        }

        //finding final coordinates
        int X_Cordinate=0, Y_Cordinate=0;
        for(Command c: commands){
            switch(c.type){
                case D:
                    Y_Cordinate = Y_Cordinate - c.count;
                    break;
                case U:
                    Y_Cordinate = Y_Cordinate + c.count;
                    break;
                case L:
                    X_Cordinate = X_Cordinate - c.count;
                    break;
                case R:
                    X_Cordinate = X_Cordinate + c.count;
                    break;
                default:
                    break;
            }
        }

        return "("+X_Cordinate+", "+Y_Cordinate+")";
    }

    static void ComparatorImplementation(){
        int[] b = new int[]{9,8,7,4,5,6};
        Integer[] a = IntStream.of(b).boxed().toArray( Integer[]::new );
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    static boolean PatternChecker(String s){
        Stack<Character> st = new Stack<Character>();
        int i = 0;

        try {
            while (i < s.length()) {
                char ch = s.charAt(i);
                switch (ch) {
                    case '{':
                        st.push(ch);
                        break;
                    case '}':
                        st.pop();
                        break;
                    case '[':
                        st.push(ch);
                        break;
                    case ']':
                        st.pop();
                        break;
                    case '(':
                        st.push(ch);
                        break;
                    case ')':
                        st.pop();
                        break;
                    default:
                        break;
                }
                i++;
            }
            if(st.size()>0)
                return false;

            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

    static void TokenizerProblem(String s) {
        Tokenizer t = new Tokenizer(s);
        t.GenTokens();

    }

    static void Problem3(int[] arr) {
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
        boolean[] walls = new boolean[arr.length - 1];
        for (int x = 0; x < Math.pow(2, arr.length - 1) - 1; x++) {
            for (int i = 0; i < walls.length; i++) {
                walls[walls.length - i - 1] = (x & (1 << i)) != 0;
            }
            printComb(walls, arr);
        }
    }

    static void Problem4(String a, String b, String tillNow) {
        //    given 2 strings A and B. generate all possible solutions when B is merged in A.
        //    Ex: A = "hey"
        //    B: "sam"
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

    static void Problem1(int x) {
        // int to int array
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

    static void HashMapImplementation() {
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("one", 1);
        m.put("two", 2);
        m.put("three", 3);
        m.put("four", 4);
        m.put("five", 5);
        Iterator i = m.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry e =  (Map.Entry)(i.next());
            System.out.println(e.getKey()+" ==> "+e.getValue());
        }
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
