package String;


/*package whatever //do not write package name here */


import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationsOfAGivenString {

   static List<String>list= new ArrayList<String>();
    public static void main (String[] args) {

        Scanner s= new Scanner(System.in);
        int T=s.nextInt();

        for(int i=0;i<T;i++)
        {
            String string= s.next();
            char[] charr= string.toCharArray();

            int n=charr.length;
            printPermutations(charr,0,n-1);
          //  Arrays.sort(list);d


            System.out.println();



        }



    }
    private static void printPermutations(char[] arr, int start, int end)
    {
        //  System.out.println("start= "+start+" end= "+end);
        if(start==end)
        {
            System.out.print(String.valueOf(arr)+" ");
            list.add(String.valueOf(arr));
            return;

        }

        for(int i=start;i<=end;i++)
        {
//            char[]arr2= arr.clone();
            //          System.out.println("j= "+j);

            char temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;


            //if(j!=end) {
            // }
            printPermutations(arr,start+1,end);
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;


        }



    }


}