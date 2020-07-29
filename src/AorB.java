import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AorB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int k = s.nextInt();
            String a = s.next();
            String b = s.next();
            String c = s.next();
            aOrB(k, a, b, c);
        }


    }

    private static void aOrB(int k, String a, String b, String c) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> mapReverse = new HashMap<>();
        updateMap(map);
        updateMapReverse(mapReverse);
        int la = a.length();
        int lb = b.length();
        int lc = c.length();
        int maxlength = la > lb ? la : lb;
        maxlength = maxlength > lc ? maxlength : lc;


        String aa = booleanString(map, a, maxlength);
        String bb = booleanString(map, b, maxlength);
        String cc = booleanString(map, c, maxlength);

        maxlength = 4 * maxlength;

        char[] charrA = new char[maxlength];
        char[] charrB = new char[maxlength];
        // System.out.println(aa);
        //  System.out.println(bb);
        //  System.out.println(cc);
        for (int i = 0; i < maxlength; i++) {
            if (k < 0) {
                break;
            }
            int ia = aa.charAt(i) - 48;
            int ib = bb.charAt(i) - 48;
            int ic = cc.charAt(i) - 48;


            if ((ia | ib) == ic) {
                charrA[i] = (char) (ia + 48);
                charrB[i] = (char) (ib + 48);
                continue;
            } else {

                if (ib == 0 && ia == 0 && ic == 1) {
                    charrA[i] = '0';
                    charrB[i] = '1';
                    k--;
                } else if (ib == 1 && ia == 0 && ic == 0) {
                    charrA[i] = '0';
                    charrB[i] = '0';
                    k--;

                } else if (ib == 0 && ia == 1 && ic == 0) {
                    charrA[i] = '0';
                    charrB[i] = '0';
                    k--;

                } else if (ib == 1 && ia == 1 && ic == 0) {
                    charrA[i] = '0';
                    charrB[i] = '0';
                    k = k - 2;

                }

            }
        }
        if (k < 0) {
            System.out.println(-1);
        } else {
            int index = 0;
            while (k > 0 && index < maxlength) {
                if (charrB[index] == '1' && charrA[index] == '1') {
                    charrA[index] = '0';
//                        index--;
                    k--;
                } else if (charrB[index]  == '0' && charrA[index] == '1' && k > 1) {
                    charrA[index] = '0';
                    charrB[index] = '1';

                    k = k - 2;

                }
                index++;

            }

            StringBuilder finalString = new StringBuilder();

            for (int x = 0; x < maxlength; x = x + 4) {
                String st = mapReverse.get(String.valueOf(charrA).substring(x, x + 4));
                if (finalString.length() != 0 && st.isEmpty()) {
                    finalString.append('0');
                } else {
                    finalString.append(st);
                }
            }
            if (finalString.length() == 0) {
                System.out.println('0');
            } else {
                System.out.println(finalString);
            }

            finalString = new StringBuilder();

            for (int x = 0; x < maxlength; x = x + 4) {
                String st = mapReverse.get(String.valueOf(charrB).substring(x, x + 4));
                if (finalString.length() != 0 && st.isEmpty()) {
                    finalString.append('0');
                } else {
                    finalString.append(st);
                }
            }
            if (finalString.length() == 0) {
                System.out.println('0');
            } else {
                System.out.println(finalString);
            }

        }

    }

    private static void updateMapReverse(Map<String, String> map) {
        map.put("0000", "");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");

    }

    private static String booleanString(Map<String, String> map, String a, int maxlength)
            {

        StringBuilder string = new StringBuilder("");
        for (int i = 0; i < maxlength; i++) {
            if (i >= a.length()) {
                string.insert(0, "0000");

            } else {
                string.append(map.get(String.valueOf(a.charAt(i))));

            }


        }
        return string.toString();

    }

    private static void updateMap(Map<String, String> map) {
        map.put("0", "0000");
        map.put("1", "0001");
        map.put("2", "0010");
        map.put("3", "0011");
        map.put("4", "0100");
        map.put("5", "0101");
        map.put("6", "0110");
        map.put("7", "0111");
        map.put("8", "1000");
        map.put("9", "1001");
        map.put("A", "1010");
        map.put("B", "1011");
        map.put("C", "1100");
        map.put("D", "1101");
        map.put("E", "1110");
        map.put("F", "1111");


    }


}
