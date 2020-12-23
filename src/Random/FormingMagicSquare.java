import java.util.Scanner;

public class FormingMagicSquare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        int[][][] arr11 = {{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}, {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}}, {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}, {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}, {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}};

        int min = Integer.MAX_VALUE;
        int sum = 0;

    for(int k=0;k<8;k++)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                sum+=Math.abs(arr11[k][i][j]-arr[i][j]);
            }
        }
        if(sum<min)
        {
            min=sum;
        }
        sum=0;


    }

        System.out.println(min);


    }


}
