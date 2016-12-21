package sedgewick.algos.chapterOne.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class LoadBalancing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        LoadBalancing balancer = new LoadBalancing(n);
       /* for(int i = 0;i<n; i++){
            int index = StdRandom.uniform(n);
            balancer.hit(index);
        }*/

        for(int i =0; i<n;i++){
            int index1 = StdRandom.uniform(n);
            int index2 = StdRandom.uniform(n);
            balancer.hit(balancer.leastBusy(index1, index2));
        }

        double avg = balancer.avg();
        int max = balancer.maxLoad();

        System.out.println("Average load "+avg);
       // System.out.println("Expected max load "+ Math.log10(n)/Math.log(Math.log(n))+ " Actual : "+max);
        System.out.println("Expected max load "+ Math.log(Math.log(n))+ " Actual : "+max);
        //balancer.print();

    }


    private int[] resources;

    public LoadBalancing(int n) {
        this.resources = new int[n];
    }

    public int leastBusy(int a, int b){
        return resources[a] > resources[b] ? b : a;
    }

    public void hit(int index){
        resources[index] = resources[index]+1;
    }

    public void print(){
        Arrays.stream(resources).forEach(System.out::print);
    }

    public double avg(){
        double totalLoad = 0;
        double totalUsedResources = 0;
        for(int i =0; i<resources.length; totalLoad+=resources[i], totalUsedResources+=resources[i++] == 0 ? 0 : 1);
        return totalLoad/totalUsedResources;
    }

    public int maxLoad(){
        int max = 0;
        for(int i =0; i < resources.length; max = Math.max(max, resources[i++]));
        return max;
    }
}
