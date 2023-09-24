package Random;//import sun.awt.X11.XSystemTrayPeer;

import java.util.Scanner;

public class CountPalindrome {
    public static void main(String[] args)
    {
          Scanner s= new Scanner(System.in);
          int T=s.nextInt();
          for(int i=0;i<T;i++)
          {
              int A=s.nextInt();
              int B=s.nextInt();
              int count=0;

              for(int j=A;j<=B;j++)
              {
                  int reverse=0;
                  int x=j;
                  while(x>0)
                  {
                      reverse=(reverse*10)+x%10;
                      x=x/10;

                  }
                  if(reverse==j){
                      count++;
                  }


              }
              System.out.println(count);

          }



    }
}
