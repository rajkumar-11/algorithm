import java.util.Arrays;

public class Ocle {
    public static void main(String[] args) {
        int n = 10;
        // int i=1;
        int[][] arr = new int[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n - i; j++) {
                arr[i][j] = 0;
            }
            if (i == 0) {
                arr[i][j - 1] = 1;
            } else {
                arr[i][j - 1] = 1;
                j = j + 1;
                //  System.out.println("i= "+i+" j= "+j);
                //System.out.println();
                for (; j <= 2 * n - 1 - 2; j = j + 2) {  // if()
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
                }
                //  arr[]

            }
            if (i == n - 1) {
                arr[i][2 * i] = 1;
            }


        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


    }


}
