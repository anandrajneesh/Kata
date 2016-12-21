package sedgewick.algos.chapterOne.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class StackAndMax {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int x){
        stack.push(x);
        if(maxStack.isEmpty() || maxStack.peek() < x)
            maxStack.push(x);
    }

    public Integer max(){
        return maxStack.peek();
    }

    public Integer pop(){
        Integer x = stack.pop();
        if(x ==(int) maxStack.peek())
            maxStack.pop();
        return x;
    }

    public static void main(String[] args) {
        try{
            StackAndMax st = new StackAndMax();
            while(true){
                String s = StdIn.readLine();
                switch (s){
                    case "q" : return;
                    case "pop" :
                        System.out.println("Popped "+st.pop());
                        break;
                    case "max" :
                        System.out.println("Max "+st.max());
                        break;
                    default:
                        int x = Integer.parseInt(s);
                        st.push(x);
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
