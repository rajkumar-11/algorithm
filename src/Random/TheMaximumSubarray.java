import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheMaximumSubarray {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr)
     {
        int[] result=new int[2];
        int max=Integer.MIN_VALUE;
        int l=arr.length;
        int  sum=0;
        int max1=Integer.MIN_VALUE;
        int sum1=0;
        for(int i=0;i<l;i++)
        {
           sum=sum+arr[i];
           
           if(arr[i]>max1)
           {
                   max1=arr[i];
           }

           sum1=sum1+arr[i];

           if (sum>max)
           {
                max=sum;
           }
           if(sum<0)
           {
                   sum=0;
           }
           if(sum1>max1)
           {
                   max1=sum1;
           }
           else
           {
                   sum1=max1;
           }


        }
        result[0]=max;
        result[1]=max1;



     return  result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.close();

        scanner.close();
    }
}
