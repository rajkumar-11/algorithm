package SearchingAndSorting;

import java.util.Scanner;

public class CountingSort2 {
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
		int sum=0;
		for (int i = 0; i < 100; i++) {
			for(int j=0;j<temp[i];j++)
			{
				System.out.print(i+" ");
			}
		}

	}
}
