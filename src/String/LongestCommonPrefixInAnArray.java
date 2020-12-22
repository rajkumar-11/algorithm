package String;

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonPrefixInAnArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            String[] sarr = new String[N];
            int min = 10000;
            for (int j = 0; j < N; j++) {
                sarr[j] = s.next();
                min = Math.min(sarr[i].length(), min);
            }
            int result = 0;
        //    System.out.println("min= " + min);
            for (int j = 0; j < min; j++) {
                boolean flag = true;
                for (int k = 0; k < N - 1; k++) {
              //      System.out.println("k= "+k);
                    if (sarr[k].charAt(j) == sarr[k + 1].charAt(j)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }

                }
                if (flag == true) {
                    result++;
                } else {
                    break;
                }

            }
            System.out.println(sarr[1].substring(0,result));

        }
    }
}