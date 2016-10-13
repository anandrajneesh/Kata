package j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Anand_Rajneesh on 7/11/2016.
 */
public class Stream101 {

    public static void main(String[] args) {

        try{

            List<Integer> numbers = new ArrayList<>();
            numbers.add(7);
            numbers.add(18);
            numbers.add(24);
            numbers.add(10);
            numbers.add(17);
            numbers.add(5);

            Stream<Integer> stream = numbers.stream();

            stream.forEach(System.out::println);

            numbers.stream().filter(n -> n%2 ==1).count();

            Optional<Integer> min= numbers.stream().min(Integer::compare);
            System.out.println("Min" + (min.isPresent() ? min.get() : "Nothing"));

            Optional<Integer> max= numbers.stream().max(Integer::compare);
            System.out.println("Max" + (max.isPresent() ? max.get() : "Nothing"));


            numbers.stream().sorted().map(n  -> n+"1").forEach(System.out::println);


            System.out.println(numbers.stream().reduce(1, (a,b) -> {
                if(b%2==1) return a*b;
                else return a;
            }));

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public int d(int d){
        d = 10;

        return d+1;
    }


}
