package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConnectnRopesWithMinimumCost
    {
	  public static void main(String[] args)
	{
		Integer arr[] = { 4, 3, 2, 6 };
		int size = arr.length;
		System.out.println("Total cost for connecting" + " ropes is " + minCost(arr, size));
	}

	private static int minCost(Integer[] arr, int size) {
//		Arrays.sort(arr);
		int result = 0;

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

		Collections.sort(list);
		
//		for (int i = 0; i < list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}

		 while(list.size()>=2)
		 {
//			 System.out.println("size="+list.size());
		   int x=list.get(0)+list.get(1);
		   list.remove(0);
		   list.remove(0);
		   result+=x;
		   list.add(x);
		
		   Collections.sort(list);
		
		 }

		return result;
	}
}
