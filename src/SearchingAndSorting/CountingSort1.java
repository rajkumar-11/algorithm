package SearchingAndSorting;

import java.util.Scanner;

public class CountingSort1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int[] temp = new int[100];
		for (int i = 0; i < n; i++) {
			temp[arr[i]]++;
		}
		for (int i = 0; i < 100; i++) {
			System.out.print(temp[i] + " ");
		}

	}
}
