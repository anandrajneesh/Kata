package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Random;

/**
 * Created by Anand_Rajneesh on 11/9/2016.
 */
public class StackPermutationChecker {

    public static void main(String[] args) {

        int num = 0;
        Random rand = new Random();
        Stack<Integer> stack = new Stack<>();
        while(num<10){
            boolean popOp = rand.nextInt()%2 == 0;
            if(popOp && !stack.isEmpty()){
                System.out.print(stack.pop());
            }else{
                stack.push(num++);
            }
        }

        while(stack.size() > 0){
            System.out.print(stack.pop());
        }
    }
}
