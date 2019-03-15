package Array;

public class MaximumSumRectangleIInA2DMatrix {
	public static void main(String[] args) {
		findMaxSubMatrix(
				new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });

	}

	private static void findMaxSubMatrix(int[][] M) {
		int Rows = M.length;
		int Cols = M[0].length;
		int max = Integer.MIN_VALUE;
		int l=0,r=0,t=0,b=0;

		for (int Lcol = 0; Lcol < Cols; Lcol++) {
			int[] sum = new int[Rows];

			for (int RCol = Lcol; RCol < Cols; RCol++) {
				for (int i = 0; i < Rows; i++) {
					sum[i] += M[i][RCol];
				}
				int[] result = Kadane(sum);
//				System.out.println("maxTemp= "+result[0]);
				if(result[0]>max)
				{
					
					max=result[0];
					l=Lcol;
					r=RCol;
					t=result[1];
					b=result[2];				
				}
				

			}

		}
		System.out.println("Max value= "+max);
		System.out.println("Dimesions are ");
		System.out.println(("("+l+","+r+")"));
		System.out.println(("("+t+","+b+")"));

	}

	private static int[] Kadane(int[] sum) {
		int[] result = new int[3];

		result[0] = sum[0];
		int start = 0;
		int end = 0;
		result[1] = 0;
		result[2] = 0;
		int tempmax = sum[0];
		for (int i = 1; i < sum.length; i++) {
			if (tempmax <= 0) 
			{
				start = i;
				
				tempmax = sum[i];
			}
			else
			{
				tempmax += sum[i];
				end = i;
			}
			
			
			if (tempmax > result[0]) {
				result[0] = tempmax;
				result[1] = start;
				result[2] = end;
			}
			

		}
		

		return result;
	}

}
