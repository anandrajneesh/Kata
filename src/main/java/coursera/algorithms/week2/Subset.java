package coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Anand_Rajneesh on 10/7/2016.
 */
public class Subset {

    public static void main(String[] args){

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rQ = new RandomizedQueue<>();
        while(true){
            try {
                rQ.enqueue(StdIn.readString());
            }catch (Exception e){
                break;
            }
        }

        while(k>0){
            System.out.println(rQ.dequeue());
            k--;
        }
    }
}
