package betterprogrammer;

import java.util.*;

/**
 * Created by Anand_Rajneesh on 7/21/2016.
 */

public class BetterProgrammerTask {

    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(countWords("this is my home"));
    }

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }



    public static double getAverage(Node root) {
        List<Node> nodes = traverseTreeInDepth(root);
        double sum = 0.0;
        for(Node n : nodes){
            sum+=n.getValue();
        }
        return sum/nodes.size();
    }

    public static int countWords(String s) {
        int count = 0;
        boolean word = false;
        for(int i =0; i<s.length();i++){
            char a = s.charAt(i);
            if((!Character.isWhitespace(a)) && i == s.length()-1){
                count++;
            }
            else if(!Character.isWhitespace(a)){
                word = true;
            }else if(Character.isWhitespace(a) && word){
                word = false;
                count++;
            }
        }
        return count;
    }

    public static Object[] reverseArray(Object[] a) {

        Object [] b = new Object[a.length];
        for(int i = a.length-1; i>=0;i--){
            b[a.length-1-i] = a[i];
        }
        return b;
    }



    public static List<String> transferFromAtoC(int n) {
       return hanoi(n,'A','B','C');
    }

    public static List<String> hanoi(int disks, char source, char temp, char dest){
        if(disks ==0){
            return new ArrayList<>();
        }
        List<String> moves = new ArrayList<>();
        moves.addAll(hanoi(disks-1, source, dest, temp));
        moves.add(source+""+dest);
        moves.addAll(hanoi(disks-1,temp,dest,source));
        return moves;
    }





    public static List<Node> traverseTreeInDepth(Node root) {
        if(root.getChildren() == null || root.getChildren().isEmpty()){
            return new ArrayList<Node>();
        }
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(root);
        for(Node n : root.getChildren()){
            nodes.addAll(traverseTreeInDepth(n));
        }
        return nodes;
    }

    public static int getCountOfOnes(int n) {
        int count = 0;
        while(n != 0){
            if(n%2 == 1){
                count++;
            }
            n = n/2;
        }
        return count;
    }

    public static int[] retainPositiveNumbers(int[] a) {
        Arrays.sort(a);
        List<Integer> pos = new ArrayList<>();
        for(int x : a){
            if (x > 0){
                pos.add(x);
            }
        }
        int [] b = new int[pos.size()];
        for(int i =0 ; i< pos.size();i++){
            b[i] = pos.get(i);
        }
        Arrays.sort(b);
        return b;
    }




    public static void sortIgnoringSpaces(String[] a) {
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }


    public static Change getCorrectChange(int cents) {
        int dollars = cents/100;
        cents = cents%100;
        int quarters = cents/25;
        cents = cents%25;
        int dimes = cents/10;
        cents =cents%10;
        int nickels = cents/5;
        cents = cents%5;
        return new Change(dollars,quarters,dimes,nickels,cents);
    }


    // Please do not change this class
    static class Change {
        private final int _dollars; //100 cents
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }
}

