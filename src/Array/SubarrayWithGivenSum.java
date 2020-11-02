package Array;/*package whatever //do not write package name here */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayWithGivenSum {
    public static void main (String[] args) {

        Scanner S= new Scanner(System.in);
        int T=S.nextInt();
        for(int i=0;i<T;i++)
        {
            int N=S.nextInt();
            int Sum=S.nextInt();
            int[]arr= new int[N];
            for(int j=0;j<N;j++)
            {
                arr[j]=S.nextInt();

            }
            boolean flag=false;
            int tempSum=0;
            int start=0;
            int end=0;
            int j=0;

            while(j<=N ||(start<=end && end<=N))
            {


                if(tempSum>Sum)
                {
                    tempSum-=arr[start];
                    start++;
                    //  continue;

                }
                else if(tempSum<Sum && j<N)
                {
                    end++;
                    tempSum+=arr[j];
                    j++;

                }
                else
                {
                    break;
                }

                //   System.out.println(tempSum);
                if(tempSum==Sum)
                {
                    flag=true;
                    break;
                }

            }
            if(flag==true)
            {
                System.out.println((start+1)+" "+(end));

            }
            else{
                System.out.println(-1);
            }


        }
    }
}