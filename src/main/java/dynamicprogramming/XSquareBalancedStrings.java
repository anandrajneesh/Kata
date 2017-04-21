package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/23/2017.
 */
public class XSquareBalancedStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t-- > 0) {
            String s = in.nextLine();
            int[] letters = new int[26];
            boolean balanced = true;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                letters[index]++;
            }
            for(int i = 0; i<26; i++){
                if(letters[i] % 2 != 0){
                    balanced = false;
                    break;
                }
            }
            System.out.println(balanced ? 1 : -1);
        }
    }
}
