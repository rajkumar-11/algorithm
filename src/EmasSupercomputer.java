import java.util.Scanner;

public class EmasSupercomputer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        String[] string = new String[n];
        for (int i = 0; i < n; i++) {
            string[i] = s.next();
        }
        int maxProduct = 1;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (string[i].charAt(j) == 'B') {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int side = 0;
                int left = j - 1, right = j + 1, top = i - 1, bottom = i + 1;
                if (arr[i][j] == -1) {
                    continue;
                } else {
                    while (left >= 0 && right < m && top >= 0 && bottom < n && arr[i][left] >= 0 && arr[i][right] >= 0 && arr[top][j] >= 0 && arr[bottom][j] >= 0) {
                        side++;
                        left--;
                        right++;
                        top--;
                        bottom++;

                    }
                    arr[i][j] = side;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j] + " ");
//
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (arr[i][j] > 0) {
                    int tempmax = findMax(arr, i, j, n, m);
                    //  System.out.println("tempmax= "+tempmax);
                    if (tempmax > maxProduct) {
                        maxProduct = tempmax;
                    }
                }
            }
        }
        System.out.println(maxProduct);


    }

    private static int findMax(int[][] arr, int i, int j, int n, int m) {
        int[][] arrtemp = new int[n][m];
        int m1 = arr[i][j];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                arrtemp[x][y] = arr[x][y];
            }
        }
//            arr[i][0]=10;
//        System.out.println(arrtemp[i][0]);
        arrtemp[i][j] = -1;
        //  System.out.println("m1= "+m1);

        for (int x = 1; x <= m1; x++) {
            arrtemp[i][j - x] = -1;
            arrtemp[i][j + x] = -1;
            arrtemp[i - x][j] = -1;
            arrtemp[i + x][j] = -1;
        }
        for (int x = 1; x < n - 1; x++) {
            for (int y = 1; y < m - 1; y++) {
                int side = 0;
                int left = y - 1, right = y + 1, top = x - 1, bottom = x + 1;
                if (arrtemp[x][y] == -1) {
                    continue;
                } else {
                    while (left >= 0 && right < m && top >= 0 && bottom < n && arrtemp[x][left] >= 0 && arrtemp[x][right] >= 0 && arrtemp[top][y] >= 0 && arrtemp[bottom][y] >= 0) {
                        side++;
                        left--;
                        right++;
                        top--;
                        bottom++;

                    }
                    arrtemp[x][y] = side;
                }
            }
        }


        int max = (m1 * 4 + 1);
        for (int x = 0; x < n - 1; x++) {
            for (int y = 0; y < m - 1; y++) {
                // System.out.println("value="+arrtemp[x][y]);
                if (arrtemp[x][y] > 0 && (m1 * 4 + 1) * (arrtemp[x][y] * 4 + 1) > max) {
                    max = (m1 * 4 + 1) * (arrtemp[x][y] * 4 + 1);
                }
            }
        }

//        for(int x=0;x<n;x++)
//        {
//            for(int y=0;y<m;y++)
//            {
//                System.out.print(arrtemp[x][y]+" ");
//            }
//            System.out.println();
//        }


        return max;


    }

}
