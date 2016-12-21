package projecteuler;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by anand_rajneesh on 11/28/2016.
 */
public class Problem27 {

    public static Map<Integer, Boolean> primeStatus = new HashMap<>();

    public static void solve(){
        List<Integer> primes = calcPrimes();
        BiFunction<Integer, Integer, Function<BiFunction<Integer,Integer,Integer>, Integer>> a_b = (a,b) -> (fn) -> fn.apply(a,b);
        //BiFunction<Integer, Integer, Function<Integer,Integer>> quadraticExpr = (a,b) -> (n) -> n*2+a*n+b;
        BiFunction<Integer, Integer, Integer> product = (a,b) -> a*b;
        Function<Function<BiFunction<Integer,Integer,Integer>, Integer>, Integer> d = fn -> fn.apply(product);
        // System.out.println(a_b.apply(4,3).apply(quadExpr));
        // System.out.println(a_b.apply(4,3).apply(product));



        Integer answer = primes.stream()
                .map(b -> IntStream.range(-1000,1001).mapToObj(a -> a_b.apply(a,b)))
                .flatMap(fn -> fn)
                .map(fn -> {
                    List<Integer> nums = new ArrayList<>();
                    IntStream
                            .iterate(0, x-> x+1)
                            .map(x-> fn.apply((a,b) -> x*x+a*x+b))
                            .peek(x-> {
                                if(isPrime(x)) nums.add(x);
                            })
                            .allMatch(Problem27::isPrime);
                    return new AbstractMap.SimpleImmutableEntry<>(fn, nums.size());
                })
                .max((e1, e2) -> e1.getValue() - e2.getValue())
                .map(e -> e.getKey().apply(product))
                .get();


        System.out.println(answer);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1601));
        solve3();
    }


    public static void solve3(){
        Long time = System.currentTimeMillis();
        List<Integer> primes = calcPrimes();
        int product = 0;
        int count = 0;
        for(int b : primes){
            for(int a = -1000; a <= 1000; a++){
                int t = 0;
                for(int n = 0, x = n*n+a*n+b; isPrime(x) && isPositive(x); t++, n++, x = n*n+a*n+b);
                if(t>count){
                    count = t;
                    product = a*b;
                }
            }
        }
        System.out.println(product);
        System.out.println(System.currentTimeMillis()-time);
    }

    public static List<Integer> calcPrimes() {

        return IntStream.range(1, 1000)
                .filter(x -> !IntStream.range(2, (int) Math.sqrt(x) + 1)
                        .anyMatch(i -> x % i == 0)
                )
                .boxed()
                .collect(Collectors.toList());
    }


    public static boolean isPositive(int i){
        return i > 0;
    }

    public static boolean isPrime(int i) {
        if(!primeStatus.containsKey(i)) {
            boolean isNotPrime = IntStream.rangeClosed(2, (int) Math.sqrt(i))
                    .anyMatch(x -> i% x == 0);
            primeStatus.put(i, !isNotPrime);
        }
        return primeStatus.get(i);
    }
}
