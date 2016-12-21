package sedgewick.algos.chapterOne.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class MinimumStack {

    public static void main(String[] args) {
        try{
            MinimumStack st = new MinimumStack();
            while(true){
                String s = StdIn.readLine();
                switch (s){
                    case "q" : return;
                    case "pop" :
                        System.out.println("Popped "+st.pop());
                        break;
                    case "min" :
                        System.out.println("Min "+st.min());
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

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x){
        stack.push(x);
        if(min.isEmpty()){
            min.push(x);
        }
        else if(min.peek() > x){
            min.push(x);
        }
    }

    public int pop(){
        if(stack.isEmpty()) throw new IllegalArgumentException();
        int x = stack.pop();
        if(x == min.peek()){
            min.pop();
        }
        return x;
    }

    public int min(){
        if(min.isEmpty()) throw new IllegalArgumentException();
        return min.peek();
    }
}
