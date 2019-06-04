package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quicksort1Partition {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int p = arr[0];
		int index = 0;
		ArrayList<Integer> list1=new ArrayList<Integer>();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		for (int i = 1; i < n; i++) 
		{
			if (arr[i] <= p)
			{
				list1.add(arr[i]);
//				index = index + 1;
			}
			else
			{
				list2.add(arr[i]);
			}
//			System.out.println(Arrays.toString(arr));
		}
		arr[index] = p;
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.print(p+" ");
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}

	}

	
}
