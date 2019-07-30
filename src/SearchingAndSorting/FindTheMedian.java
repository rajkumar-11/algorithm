package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}	
		Arrays.sort(arr);
		int x=n/2;
		System.out.println(arr[x]);
	}

}
