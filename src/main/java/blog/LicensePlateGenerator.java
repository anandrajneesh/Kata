package blog;

import sedgewick.algos.strings.LSD;
import sedgewick.algos.strings.MSD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 3/18/2017.
 */
public class LicensePlateGenerator {

    private static String[] stateCodes = {
            "AN", "AP", "AR", "AS", "BR", "CH", "DN", "DD",
            "DL", "GA", "GJ", "HR", "HP", "JK", "KA", "KL",
            "LD", "MP", "MH", "MN", "ML", "MZ", "NL", "OR",
            "PY", "PB", "RJ", "SK", "TN", "TR", "UP", "WB"
    };

    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\resources\\plates.txt"))) {
            Random stateCodeRandom = new Random();
            Random twoDigitRandom = new Random();
            Random twoAlphabetRandom = new Random();
            Random fourDigitRandom = new Random();
            int noOfPlates = 1600000;
            Set<String> plates = new HashSet<>(noOfPlates + 1);
            while (plates.size() < noOfPlates) {
                int stateCode = stateCodeRandom.nextInt(stateCodes.length);
                int twoDigits = twoDigitRandom.nextInt(100);
                int firstAlphabet = twoAlphabetRandom.nextInt(26);
                int secondAlphabet = twoAlphabetRandom.nextInt(26);
                int fourDigits = fourDigitRandom.nextInt(10000);
                plates.add(licensePlate(stateCode, twoDigits, firstAlphabet, secondAlphabet, fourDigits));
            }
            /*plates.stream().forEach(System.out::println);
            plates.stream().forEach(x -> {
                try {
                    bw.write(x);
                    bw.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });*/
            System.out.println("plates length " + plates.size());
            String[] a = new String[plates.size()];
            a = plates.toArray(a);
            testTimings(a, MSD::sort, "MSD");
            a = new String[plates.size()];
            a = plates.toArray(a);
            testTimings(a, LSD::sort, "LSD");
            List<String> p = plates.stream().collect(Collectors.toList());
            long startTime = System.currentTimeMillis();
            Collections.sort(p);
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + " ms taken by " + " Collections sort");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String licensePlate(int stateCode, int twoDigits, int firstAlphabet, int secondAlphabet, int fourDigits) {
        StringBuilder stb = new StringBuilder();
        char a = 'A';
        char b = (char) (a + firstAlphabet);
        char c = (char) (a + secondAlphabet);
        stb
                .append(stateCodes[stateCode])
                .append(normalize(twoDigits, 2))
                .append(b)
                .append(c)
                .append(normalize(fourDigits, 4));
        return stb.toString();
    }

    public static String normalize(int x, int len) {
        if (x == 0) {
            if (len == 2)
                return "00";
            else if (len == 4)
                return "0000";
        }
        if (x < 10) {
            if (len == 2)
                return "0" + x;
            else if (len == 4)
                return "000" + x;
        }
        if (len == 4) {
            if (x < 100)
                return "00" + x;
            if (x < 1000)
                return "0" + x;
        }
        return Integer.toString(x);
    }


    public static void testTimings(String[] input, Consumer<String[]> func, String name) {
        long startTime = System.currentTimeMillis();
        func.accept(input);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms taken by " + name);
    }

}
