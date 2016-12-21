package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Scanner;

/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class PallindromChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().toLowerCase();
        Stack<Character> sc = new Stack<>();
        Queue<Character> qc = new Queue<>();
        for(char c : s.toCharArray()){
            if(c <='z'  && c >='a') {
                sc.push(c);
                qc.enqueue(c);
            }
        }

        while(!sc.isEmpty()&& !qc.isEmpty() && sc.pop() == qc.dequeue());

        if(sc.isEmpty() && qc.isEmpty()){
            System.out.println("Pallindrome - true");
        }else{
            System.out.println("Not a pallindrome");
        }


    }
}
