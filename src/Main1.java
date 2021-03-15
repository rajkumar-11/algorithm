import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.lang.*;
import java.util.*;

public class Main1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] arr = line.split(";");
            Double d = new Double("0.0");


            //   Map<Double,String>map= new HashMap<>();

            Double pp = Double.valueOf(arr[0]);
            Double ch = Double.valueOf(arr[1]);

            System.out.println("pp= " + pp + " ch= " + ch);

            if (ch < pp) {
                System.out.println("ERROR");
            } else if (ch.equals(pp)) {
                System.out.println("ZERO");
            } else {
                Double diff = ch - pp;
                List<String> list = new ArrayList<>();

                while (diff > 0.0) {
                    if (diff >= 100.00) {
                        list.add("ONE HUNDRED");
                        diff = diff - 100.00;
                    } else if (diff >= 50.00 && diff < 100.00) {
                        list.add("FIFTY");
                        diff = diff - 50.00;

                    } else if (diff >= 20.00 && diff < 50.00) {
                        list.add("TWENTY");
                        diff = diff - 20.00;

                    } else if (diff >= 10.00 && diff < 20.00) {
                        list.add("TEN");
                        diff = diff - 10.00;

                    } else if (diff >= 5.00 && diff < 10.00) {
                        list.add("FIVE");
                        diff = diff - 5.00;

                    } else if (diff >= 2.00 && diff < 5.00) {
                        list.add("TWO");
                        diff = diff - 2.00;

                    } else if (diff >= 1.00 && diff < 2.00) {
                        list.add("ONE");
                        diff = diff - 1.00;

                    } else if (diff >= 0.50 && diff < 1.00) {
                        list.add("HALF DOLLAR");
                        diff = diff - 0.50;

                    } else if (diff >= 0.25 && diff < 0.50) {
                        list.add("QUATER");
                        diff = diff - 0.25;

                    } else if (diff >= 0.10 && diff < 0.25) {
                        list.add("DIME");
                        diff = diff - 0.10;

                    } else if (diff >= 0.05 && diff < 0.10) {
                        list.add("NICKEL");
                        diff = diff - 0.05;

                    } else if (diff >= 0.01) {
                        list.add("PENNY");
                        diff = diff - 0.01;

                    }
                    else {
                        break;
                    }
                    System.out.println("diff= " + diff);
                }
                System.out.println("Here");
                Collections.sort(list);
                int i = 0;
                for (String s : list) {
                    if (i != list.size() - 1) {
                        System.out.print(s + ";");
                    } else {
                        System.out.println(s);
                    }
                    i++;

                }
                System.out.println("Khatam");


            }


        }
    }
}
