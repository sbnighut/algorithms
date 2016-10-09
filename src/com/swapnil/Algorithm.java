package com.swapnil;


import java.util.Arrays;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Queue;

import apple.laf.JRSUIUtils;
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
//        NumberToHex(51);
//        NumberToString(2345);
//        String z = longestPalindrome("bb");
//        dfs();
//        TokenizerProblem("He isn't a good man");
//        HashMapImplementation();
//        PatternChecker("[AZ[a-z](a-z)");
//        movePlane("7U3DX2D");
//        threeSum(new int[]{2,5,-7, 3, -5});
//        movePlane("7U3DX2D");

//        LCA();
//        addTwoNumbersAlgo();
//        maxSlidingWindow(new int[]{1, -1}, 1);
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int prevLeft = 0;
        int prevRight = k-1;
        int prevMaxIndex = 0;
        int max = -99999;
        int[] maxArray = nums.length>0? new int[nums.length-k+1]: new int[0];
        for(int i=0;i<k;i++){
            if(nums[i] > max){
                max = nums[i];
                prevMaxIndex = i;
            }
            maxArray[0] = max;
        }
        for(int i=1;i<=nums.length-k;i++){
            if(prevMaxIndex >= i && nums[i+k-1] > max){
                prevMaxIndex = i+k-1;
                max = nums[i+k-1];
            }
            else if(prevMaxIndex < i){
                max = -9999;
                for(int j=i;j<i+k;j++){
                    if(nums[j] > max){
                        max = nums[j];
                        prevMaxIndex = j;
                    }
                }
            }
            maxArray[i] = max;
            prevLeft++;
            prevRight++;
        }
        return maxArray;
    }
    static void addTwoNumbersAlgo(){
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int sum =l2.val + l1.val;
        ListNode head = null;
        ListNode current = null;

        while(l2 != null || l1 != null){
            ListNode l = new ListNode(0);
            if(l1 == null){
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else{
                sum = l1.val + l2.val + carry;
                l2 = l2.next;
                l1 = l1.next;
            }
            carry = sum/10;
            l.val = sum%10;
            if(head == null) {
                head = l;
                current = l;
            }
            else {
                current.next = l;
                current = current.next;
            }
        }
        if(carry == 1){
            current.next = new ListNode(1);
        }
        return head;
    }
    static void LCA(){
        TreeNode t = new TreeNode(40);
        TreeNode t1 = new TreeNode(30);
        TreeNode t2 = new TreeNode(100);
        TreeNode t3 = new TreeNode(50);
        TreeNode t4 = new TreeNode(60);
        TreeNode t5 = new TreeNode(80);
        TreeNode t6 = new TreeNode(70);
        TreeNode t7 = new TreeNode(90);
        TreeNode t8 = new TreeNode(20);
        TreeNode t9 = new TreeNode(18);
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
        t.add(t5);
        t.add(t6);
        t.add(t7);
        t.add(t8);
        t.add(t9);

        lowestCommonAncestor(t, t1, t2);
    }
    static TreeNode lowestCommonAncestor(TreeNode currentNode, TreeNode searchItem1, TreeNode searchItem2) {
        if(currentNode == null)
            return currentNode;
        else if(currentNode.val == searchItem1.val || (currentNode.val == searchItem2.val))
            return currentNode;
        else {
            TreeNode find1 = lowestCommonAncestor(currentNode.left, searchItem1, searchItem2);
            TreeNode find2 = lowestCommonAncestor(currentNode.right, searchItem1, searchItem2);
            if(find1!=null && find2!=null) {
                return currentNode;
            }

            if(find1!=null)
                return find1;
            else
                return find2;
        }
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
    static int[] twoSum(int[] nums, int target) {
        List<Integer> result = new LinkedList<Integer>();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }

        for (int i = 0; i <= nums.length / 2; i++) {
            if (m.containsKey(nums[i]) && m.containsKey(target - nums[i]) && nums[i] != target / 2) {
                result.add(m.get(nums[i]));
                result.add(m.get(target - nums[i]));
            }
        }
        return result.stream().mapToInt(k -> k).toArray();
    }
    static void NumberToString(int x) {
        int j = x;
        while (j != 0) {
            System.out.print(j % 10);
            j = j / 10;
        }
    }
    static void NumberToHex(int x) {
        int j = x;
        while (j != 0) {
            System.out.print(j % 16);
            j = j >> 4;
        }
    }
    static int checkFromMiddle(String s, int m, int isEven){
        int i,j;
        if(isEven==0){
            i=j=m;
            while(i>0 && j<s.length()-1 && s.charAt(i-1) == s.charAt(j+1)){
                i--;
                j++;
            }
            return j-i+1;
        }
        else{
            i=m;
            j = m+1;
            while(i>-1 && j<s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            return j-i-1;
        }
    }
    static String longestPalindrome(String s) {
        int i=0, j=s.length()-1;
        int max = 1;
        int max_center = 0;
        boolean isEven = false;
        while(i<s.length()-1){
            int tempMax = checkFromMiddle(s, i, 0);
            if(tempMax > max){
                max = tempMax;
                max_center = i;
                isEven = false;
            }
            tempMax = checkFromMiddle(s, i, 1);
            if(tempMax > max){
                max_center = i;
                isEven =  true;
                max = tempMax;
            }
            i++;
        }
        if(isEven)
            return s.substring(max_center- (int)(max/2)+1, max_center+(max/2)+1);
        else
            return s.substring(max_center- (int)(max/2), max_center+(max/2)+1);
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
        TNode tree = new TNode(1, 0);
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
        LinkedList<TNode> xyz = new LinkedList<TNode>();
        LinkedList<TNode> xyz2 = new LinkedList<TNode>();
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
