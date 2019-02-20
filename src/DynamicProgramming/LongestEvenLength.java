package DynamicProgramming;

public class LongestEvenLength {

	public static void main(String[] args) {

		String str = "1538023";
		System.out.println("Length of the substring is " + findLength(str));

	}

	private static int findLength(String str) {
		int length = str.length();

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < length - 1; i++) {
			int l = i - 1;
			int r = i;

			int sumleft = 0;
			int sumright = 0;
  
			int answer=0;
			
			 
			while (l >= 0 && r < length) {
				
				sumleft = sumleft + Integer.valueOf(str.charAt(l) - 48);

				sumright = sumright + Integer.valueOf(str.charAt(r) - 48);
				answer=answer+2;

//				System.out.println("sumleft =" + sumleft + " sumright= " + sumright + " i= " + i+" l= "+l+" r= "+r);
				if (sumleft == sumright)
				{
					
//					System.out.println("here");
					max = Math.max(max, answer);
				}
				l--;
				r++;

			}

		}
//		System.out.println(max);

		return max;
	}

}
