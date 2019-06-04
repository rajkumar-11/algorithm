package SearchingAndSorting;

import java.util.LinkedList;
import java.util.Scanner;

public class TheFullCountingSort {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = n / 2;
		// LinkedList arr[]= new LinkedList[100];
		// for(int i=0;i<100;i++)
		// {
		// arr[i]= new LinkedList<StringBuilder>();
		// }
		// System.out.println("n= "+n);
		// for(int i=0;i<n;i++)
		// {
		// int a=s.nextInt();
		// String string=s.next();
		//// System.out.println("a= "+a+" string= "+string);
		// if(i<x)
		// {
		// arr[a].add("-");
		//
		// }
		// else
		// {
		// arr[a].add(string);
		// }
		// }
		// for(int i=0;i<100;i++)
		// {
		// for(int j=0;j<arr[i].size();j++)
		// {
		// System.out.print(arr[i].get(j)+" ");
		// }
		// }
		StringBuilder[] st = new StringBuilder[100];
		for (int i = 0; i < 100; i++) {
			st[i] = new StringBuilder("");
		}
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			String string = s.next();
			if (i < x) {
				st[a].append("-" + " ");
			} else {
				st[a].append(string + " ");
			}

		}
		for (int i = 0; i < 100; i++) {
			System.out.print(st[i]);
		}

	}
}
