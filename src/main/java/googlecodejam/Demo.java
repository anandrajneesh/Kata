package googlecodejam;

/**
 * Created by Anand_Rajneesh on 7/29/2016.
 */
public class Demo {

    public static void main(String[] args) {
        String s = "97";
        for(int i = 2; i<=36;i++){
            try{
                int l = Integer.parseInt(s,i);
                System.out.println("Radix convert "+l);
            }catch(NumberFormatException e){
                System.out.println(i);
            }
        }

        System.out.println(Integer.parseInt("12102928",10));
        System.out.println((int)'a');
        System.out.println(Long.parseLong("97",6));
    }
}
