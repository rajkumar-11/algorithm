package String;

import java.util.*;
import java.lang.*;
import java.io.*;
public class ReverseWordsInAGivenString
{
    public static void main (String[] args) {


        Scanner s= new Scanner(System.in);
        int T=s.nextInt();
        for(int j=0;j<T;j++)
        {
            String string= s.next();
            String[]sarr= string.split(".");

            int n=sarr.length;
            System.out.println(n);

            String result="";

            for(int i=n-1;i>=0;i--)
            {
                result=result+sarr[i];
                if(i!=0)
                {
                    result+=".";
                }

            }
            System.out.println(result);
        }
    }

}
