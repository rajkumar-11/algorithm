package String;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CheckIfStringIsRotatedByTwoPlaces {
    public static void main(String[] args) {
       Scanner s= new Scanner(System.in);
       int T=s.nextInt();

       for(int i=0;i<T;i++)
       {
           String s1=s.next();
           String s2=s.next();
           int n=s1.length();
           int m=s2.length();

           if(n!=m)
           {
               System.out.println(0);
           }
           else {
          boolean flag=true;
               for (int j = 0; j < n; j++)
               {
                 if(s1.charAt(j)==s2.charAt((j+n-2)%n))
                   {
                       continue;
                   }
                   else
                   {
                       flag=false;
                       break;
                   }


               }
               if(flag==false)
               {
                   System.out.println(0);
               }
               else
               {
                   System.out.println(1);
               }
           }


       }


    }

}
