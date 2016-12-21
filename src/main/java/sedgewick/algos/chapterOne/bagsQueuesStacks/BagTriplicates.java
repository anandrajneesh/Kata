package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Iterator;

/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class BagTriplicates {
    public static void main(String[] args) {
        Stack<String> sc = new Stack<>();
        sc.push("anand");
        sc.push("java");
        sc.push("anand");
        sc.push("scala");
        sc.push("nodejs");
        sc.push("anand");
        System.out.println(hasTriplicates(sc));
    }

    public static boolean hasTriplicates(Stack<String> sc){
        boolean tripleFound = false;
        for(Iterator<String> it = sc.iterator(); it.hasNext(); ){
            String x = it.next();
            int count = 0;
            for(Iterator<String> it2 = sc.iterator(); it2.hasNext() && count<3 ; count+=x.compareTo(it2.next()) == 0 ? 1 : 0);
            if(count > 2){
                tripleFound = true;
                break;
            }
        }
        return tripleFound;
    }
}
