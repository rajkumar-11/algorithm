package String;
import java.util.*;
import java.lang.*;
import java.io.*;
public class MostFrequentWordInAnArrayOfStrings {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();

            for (int j = 0; j < N; j++) {
                String string = s.next();
                if (map.get(string) != null) {
                    map.put(string, map.get(string) + 1);
                } else {
                    map.put(string, 1);
                }
            }
            int max = 0;
            int index = 0;
            String value = "";
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey());
                if (entry.getValue() >= max) {
                    max = entry.getValue();
                    value = entry.getKey();
                }


            }
            System.out.println(value);

        }
    }
}
