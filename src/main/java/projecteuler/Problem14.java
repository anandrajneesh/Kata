package projecteuler;

/**
 * Created by Anand_Rajneesh on 8/11/2016.
 */
public class Problem14 {

    public static void main(String[] args) {
        try {

            long result = 0;
            long prevChain=0;
            for (long num = 999999, currentChain=0; num > 1; num--, currentChain=0) {
                long i = num;
                while (i > 1) {
                    if (i % 2 == 0) {
                        i /= 2;
                    } else {
                        i = (3 * i) + 1;
                    }
                    currentChain++;
                }

                if(currentChain > prevChain && i == 1){
                    prevChain = currentChain;
                    result = num;
                }
                System.out.println(num+" "+currentChain);
            }
            System.out.println("Result---> "+result+" "+prevChain);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
