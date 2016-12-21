package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class Tail {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\sedgewick\\algos\\chapterOne\\bagsQueuesStacks\\input.txt"));
            Queue<String> queue = new Queue<>();
            int k = 10;
            String tmp;
            while((tmp = br.readLine())!=null){
                if(queue.size() == k)
                    queue.dequeue();
                queue.enqueue(tmp);
            }
            while(!queue.isEmpty()){
                System.out.println(queue.dequeue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
