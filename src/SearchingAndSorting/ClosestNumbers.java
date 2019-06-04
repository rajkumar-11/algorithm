package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers 
{
  public static void main(String[] args) 
  {
	   Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int[]arr1=new int[n];
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			arr1[i]=arr[i];
		}	
		
		Arrays.sort(arr);
		int minDiff=arr1[1]-arr[0];
		list.add(arr[0]);
		list.add(arr1[0]);
		for(int i=1;i<n-1;i++)
		{
			if(arr[i+1]-arr[i]==minDiff)
			{
				list.add(arr[i]);
				list.add(arr[i+1]);
			}
			else if(arr[i+1]-arr[i]<minDiff)
			{
				list.removeAll(list);
				minDiff=arr[i+1]-arr[i];
				list.add(arr[i]);
				list.add(arr[i+1]);
			}
			
		}
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
}
}
