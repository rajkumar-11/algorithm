import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int d1 = s.nextInt();
        int m1 = s.nextInt();
        int y1 = s.nextInt();
        s.nextLine();
        int d2 = s.nextInt();
        int m2 = s.nextInt();
        int y2 = s.nextInt();

        int result = 0;

        if(y1<y2||(y1==y2 && m1<m2)||(y1==y2 &&m1==m2 &&d1<d2))
        {
            result = 0;
        }
        else if (y1 > y2)
        {
            result = 10000;
        } else if (m1 > m2)
        {
            result = 500 * (m1 - m2);
        }
        else
        {
//            System.out.println("here");
            result = 15 * (d1 - d2);
        }
        System.out.println(result);


    }
}
