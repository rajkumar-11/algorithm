package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortPart1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int temp = arr[n - 1];
		boolean flag = false;
		for (int i = n - 2; i >= 0; i--)
		{
//			System.out.println("i= "+i);
			if (arr[i] > temp) {
				arr[i + 1] = arr[i];
				printArr(arr);
			} else {
				arr[i+1] = temp;
				flag = true;
				printArr(arr);
				break;

			}
		}
		if (flag == false) {
			arr[0] = temp;
			printArr(arr);

		}

	}

	private static void printArr(int[] arr) 
	{
	 int n=arr.length;
	 for(int i=0;i<n;i++)
	 {
		 System.out.print(arr[i]+" ");
	 }
	 System.out.println();
	 
		
	}
}
