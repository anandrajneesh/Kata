package codegolf;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 9/29/2016.
 */
public class IamAdult {
    public static void main(String[] args) {
       /* String s = "19";
        System.out.println(s.compareTo("18"));
        System.out.println(s.compareTo("1.4")<0?"1.4":s.length()>2?s:s);
        System.out.println(18+(char)-1);

        double d = 1.2;
        System.out.println(d/18.0);
        System.out.println((d*10));
        System.out.println(d/18.0<0.077?1.4:d);*/
        System.out.println(c("0"));
        System.out.println(c("1"));
        System.out.println(c("2"));
        System.out.println(c("12"));
        System.out.println(c("18"));
        System.out.println(c("43"));
        System.out.println(c("122"));

        System.out.println(c("0.0"));
        System.out.println(c("1.04"));
        System.out.println(c("1.225"));
        System.out.println(c("1.399"));
        System.out.println(c("1.4"));
        System.out.println(c("1.74"));
        System.out.println(c("2.0"));
        System.out.println(c("2.72"));
      /*  String x = "1.4";

        x = x.matches("[0-1][0-7]?") ? "18": x.matches("[0-1]\\.[0-3]+]") ? "1.4":x;
        System.out.println(x);*/
        System.out.println("=============");
        String x = "1.4";
        System.out.println( x.matches("[0-1][.][^4-9]*"));

    }


    static String c(String x){
        return x.matches("[0-1][0-7]?") ? "18": x.matches("[0-1].[0-3]\\d*") ? "1.4":x;
    }

}
