package String;

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalindromeInAString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            String string = s.next();
            int n = string.length();
            int max = 1;
            int maxIndex = 0;
            int l = 1, k = 1;

            for (int j = 0; j < n - 1; j++) {
                int tempMax = 1;
                k = 1;
                l = 1;
                // maxIndex=j;
                if (string.charAt(j) == string.charAt(j + 1)) {
                    l++;
                    tempMax++;
                    while ((j - k >= 0) && (j + l <= n - 1)) {
                        //    System.out.println("j= "+j);
                        if (string.charAt(j - k) == string.charAt(j + l)) {
                            tempMax += 2;
                        } else {
                            break;
                        }
                        k++;
                        l++;
                    }
                    if (max < tempMax) {
                        max = tempMax;
                        maxIndex = j;
                    }

                }
                l=1;
                k=1;
                tempMax=1;
                System.out.println("maxIndex= "+maxIndex);

                while ((j - k >= 0) && (j + l <= n - 1)) {
                    //    System.out.println("j= "+j);
                    if (string.charAt(j - k) == string.charAt(j + l)) {
                        tempMax += 2;
                    } else {
                        break;
                    }
                    k++;
                    l++;
                }
                if (max < tempMax) {
                    max = tempMax;
                    maxIndex = j;
                }
            }



            if (max % 2 == 0) {
                int a = maxIndex - (max-1)/2;
                int b = maxIndex + (max + 1) / 2 + 1;
                System.out.println(string.substring(a, b));

            } else {
                int a = maxIndex - (max - 1) / 2;
                int b = maxIndex + (max + 1) / 2;
                System.out.println(string.substring(a, b));


            }


        }
    }
}