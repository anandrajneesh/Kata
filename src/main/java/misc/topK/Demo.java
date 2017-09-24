package misc.topK;

import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.SmartArrayBasedNodeFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by Anand Rajneesh on 9/24/2017.
 */
public class Demo {

    private static final Predicate<String> isWord = Pattern.compile("[a-zA-Z]+").asPredicate();

    private RadixTree<Entry> tree = new ConcurrentRadixTree<>(new SmartArrayBasedNodeFactory());
    private PriorityQueue<Entry> topK = new PriorityQueue<>();

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand.255174\\Desktop\\generated.txt"))){
            Demo d = new Demo();
            br.lines()
                    .map(x-> x.split(" "))
                    .flatMap(Arrays::stream)
                    .filter(isWord)
                    .forEach(d::index);
            while(!d.topK.isEmpty()){
                Entry entry = d.topK.poll();
                System.out.println(String.format("Word %s, count %s", entry.word, entry.count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void index(String arg){
        Entry entry = tree.getValueForExactKey(arg);
        if(entry == null){
            entry = new Entry(arg);
            tree.put(arg, entry);
        }else{
            entry.incrementCount();
        }
        topK.remove(entry);
        if(topK.size() < 100){
            topK.add(entry);
        }else if(topK.peek().count < entry.count){
            topK.poll();
            topK.offer(entry);
        }
    }

    private static class Entry implements Comparable<Entry>{
        final String word;
        int count;

        public Entry(String word) {
            this.word = word;
            count++;
        }

        public Entry incrementCount() {
            count++;
            return this;
        }

        @Override
        public int compareTo(Entry entry) {
            return count > entry.count  ? -1 : count == entry.count ? 0 : 1;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Entry && ((Entry) o).word.equals(word);
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }
}
