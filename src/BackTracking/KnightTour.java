package BackTracking;

public class KnightTour {
	static int N = 8;

	public static void main(String[] args) {
		solveKT();

	}

	private static void solveKT() {
		int[][] sol = new int[8][8];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				sol[i][j] = -1;
			}
		}
		sol[0][0] = 0;

		int[] xpath = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] ypath =  {1, 2, 2, 1, -1, -2, -2, -1};

		if (isSolution(sol, xpath, ypath, 0, 0, 1)) {
			System.out.println("the solution is possible");

			print(sol);
		} else
			System.out.println("impossible");

	}

	private static boolean isSolution(int[][] sol, int[] xpath, int[] ypath, int i, int j, int num) 
	{
      int x,i_next,j_next;
//      System.out.println("num= "+num);
		
		if (num == N * N)
		{

			return true;
		}

		for( x = 0; x < 8; x++)
		{
			 i_next = i + xpath[x];
			 j_next = j + ypath[x];

			if (isSafe(sol,i_next, j_next)) {
				sol[i_next][j_next] = num;
				if (isSolution(sol, xpath, ypath, i_next, j_next, num + 1)) {
					return true;
				}
				else
					sol[i_next][j_next] = -1;

				

			}

		}

		return false;
	}

	private static boolean isSafe(int[][] sol, int i, int j) {
		if (i >= 0 && i <= N - 1 && j >= 0 && j <= N - 1 && sol[i][j] == -1)
			return true;

		return false;
	}

	private static void print(int[][] sol) {
		System.out.println();
		System.out.println();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}

	}

}
