package dynamicprogramming;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/21/2017.
 */
public class IntelligentGirl {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        LinkedList<Integer>  count = new LinkedList<>();
        for(int i = s.length()-1; i>=0;i--){
            int c = s.charAt(i);
            if(c % 2 == 0){
                if(!count.isEmpty()){
                    count.addFirst(count.peek()+1);
                }else{
                    count.add(1);
                }

            }else{
                if(count.isEmpty()){
                    count.add(0);
                }else{
                    count.addFirst(count.peek());
                }

            }
        }
        for(int c : count){
            System.out.print(c+" ");
        }

    }

}
