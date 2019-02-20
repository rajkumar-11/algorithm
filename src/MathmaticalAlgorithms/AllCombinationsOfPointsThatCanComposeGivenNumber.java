package MathmaticalAlgorithms;

public class AllCombinationsOfPointsThatCanComposeGivenNumber {
	public static void main(String[] args) {

		int n = 5;
		int size = 100;
		int[] arr = new int[size];
		System.out.println("Different compositions formed by 1, 2 and 3 of " + n + " are");
		printCompositions(arr, n, 0);

	}

private static void printCompositions(int[] arr, int n, int i)
{
	int MAX_SIZE=3;
	
  if(n==0)
  {
	  printArray(arr,i);
  }
  else if(n>0)
  {
	  for(int j=1;j<=MAX_SIZE;j++)
	  {
		  arr[i]=j;
//		  n=n-j;
		  printCompositions(arr, n-j,i+1);
		  
	  }
	  
  }
  
	
}

	private static void printArray(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

}
