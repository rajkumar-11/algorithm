
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        List<Integer>lista= new ArrayList<>();
        List<Integer>listb= new ArrayList<>();
        List<Integer>listc= new ArrayList<>();

        for(int i=0;i<a.length;i++)
        {
            lista.add(a[i]);
        }
        for(int i=0;i<b.length;i++)
        {
            listb.add(a[i]);
        }
        for(int i=0;i<c.length;i++)
        {
            listc.add(a[i]);
        }

     //   int[] x=  lista.toArray();
        int[]x= new int[10];
        Integer[] y= (Integer[]) lista.toArray();
        Integer[] z= (Integer[]) lista.toArray();
        int count=0;

        for(int i=0;i<x.length;i++)
        {
            int p=x[i];
            int indexp= findIndex(y,p);
            if(indexp>=x.length)
            {
                break;
            }
            for(int j=indexp;j<y.length;j++)
            {
                int q=y[j];
                int indexq=findIndex(z,q);
                if(indexq>=z.length)
                {
                    break;
                }
                int m=(z.length-indexq-1);
                count+=(m*(m-1))/2;


            }

        }



        return count;



    }

    private static int findIndex(Integer[] y, int p) {

        int min=0;
        int max=y.length-1;
        int index=(max+min)/2;
        while(min<max)
        {
            if(y[index]==p)
            {
                return index;
            }
            else if(y[index]<p)
            {
                min=index+1;
            }
            else
            {
                max=index-1;
            }
        }
        return index+1;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
