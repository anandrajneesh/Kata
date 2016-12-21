package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Iterator;

/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class BagDuplicates {

    public static void main(String[] args) {
        Stack<String> sc = new Stack<>();
        sc.push("anand");
        sc.push("java");
        sc.push("scala");
        sc.push("nodejs");
        sc.push("anand");
        System.out.println(hasDuplicate(sc));
    }

    public static boolean hasDuplicate(Stack<String> sc){
        boolean dupFound = false;
        for(Iterator<String> it = sc.iterator(); it.hasNext(); ){
            String x = it.next();
            int count = 0;
            for(Iterator<String> it2 = sc.iterator(); it2.hasNext() && count<2 ; count+=x.compareTo(it2.next()) == 0 ? 1 : 0);
            if(count > 1){
                dupFound = true;
                break;
            }
        }
        return dupFound;
    }
}
