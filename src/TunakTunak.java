import java.util.*;

public class TunakTunak
{
    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
   // 1 1 2 3 5 8 13 21 34 55
        //   // 3 3 6 9 15
        //   // 29 29 58 87
        // a a 2a 3a 5a 8a 13a
//        int x=87;
//        int a=1;
//        int b=1;
//        int max=Integer.MIN_VALUE;
//        while(a+b<=x){
//            int c=a+b;
//            if(x%c==0){
//                max=c;
//            }
//            a=b;
//            b=c;
//
//        }
//        if(max!=Integer.MIN_VALUE){
//            System.out.println(x/max);
//        }

      //  A -> 1B -> 2C -> 3
      // 19
      // 53-> BA


        Map<Integer,Character>map= new HashMap<>();
        map.put(0,'A');
        map.put(1,'A');
        map.put(2,'A');
        map.put(3,'A');
        map.put(4,'A');
        map.put(5,'A');
        map.put(6,'A');
        map.put(7,'A');
        map.put(8,'A');
        map.put(9,'A');
        map.put(10,'A');
        map.put(11,'A');
        map.put(12,'A');
        map.put(13,'A');
        map.put(14,'A');
        map.put(15,'A');
        map.put(16,'A');
        map.put(17,'A');
        map.put(18,'A');
        map.put(19,'A');
        int x=100;
//        x=x+1;
        StringBuilder result= new StringBuilder("");
        String s="";
        while(x>0){
            int y=(x)%26;
            if(y==0){
                s=s+"Z";
            }
            else{
                char ch= (char) ('A'+y-1);
                s=s+ch;
            }

//52    Z


            System.out.println("s= "+s+" x="+x+" y="+y);
//            result.append(ch);
            x=x/26;

        }
        System.out.println("s=="+s);



    }






}