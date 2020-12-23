import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamParlor {
    static void whatFlavors(int[] cost, int money)
    {
        int size=cost.length;
        Map<Integer,ArrayList<Integer>>map= new LinkedHashMap<>();
        for(int i=0;i<size;i++)
        {
            if(map.get(cost[i])!=null)
            {
                ArrayList<Integer>list=map.get(cost[i]);
            //    System.out.println("list size= "+list.size());
                list.add(i);
                map.put(cost[i],list);
            }
            else
            {
                ArrayList<Integer>list= new ArrayList<>();
                list.add(i);
                map.put(cost[i],list);

            }

        }
        for(Map.Entry<Integer,ArrayList<Integer>>entry:map.entrySet())
        {
            int key= entry.getKey();
            int x=money-key;
            if(map.get(x)!=null)
            {
                int a=entry.getValue().get(0);
                int b=map.get(x).get(0);
                System.out.println("a= "+a+" b="+b);

                if(a==b)
                {
                    List<Integer>list= map.get(x);
                    if(list.size()!=2)
                    {
                        continue;
                    }
                     a= list.get(0);
                     b=list.get(1);
                    System.out.println((a+1)+" "+(b+1));

                }
                else
                {
                    System.out.println((a+1)+" "+(b+1));
                }

                return;
            }


        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
      //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
           // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
           // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

          //  String[] costItems = scanner.nextLine().split(" ");
           // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          //  for (int i = 0; i < n; i++) {
           //     int costItem = Integer.parseInt(costItems[i]);
           //     cost[i] = costItem;
          //  }
            for(int i=0;i<n;i++)
            {
                cost[i]=scanner.nextInt();
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }




}
