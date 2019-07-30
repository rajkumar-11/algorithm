package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotifications {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = s.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[d];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
//			arr1[i] = arr[i];
		}
		for(int i=0;i<d;i++)
		{
			arr1[i]=arr[i];
		}
		Arrays.sort(arr1);
		
//		System.out.println(Arrays.toString(arr1));
		int count = 0;
		for (int i = d; i < n; i++) {
			int median = findMedian(arr1,d);
//			System.out.println("median =" + median);
			if (arr[i] >= median) {
				count++;
			}
		   updateArr(arr1,arr[i-d],arr[i],d);
//		   System.out.println(Arrays.toString(arr1));
		}
		System.out.println(count);

	}

	private static void updateArr(int[] arr, int u, int v,int n)
	{   
//		System.out.println("u= "+u+" v= "+v);
		if(v==u)
			return;
	  	int index=findIndex(arr,u,n);
	  	
//	  	System.out.println("index= "+index);
	  	if(v>u)
	  	{
	  		arr[index]=v;
	  		InsertAtCorrectPositionForward(arr,index,v,n);
	  	}
	  	else
	  	{
	  		arr[index]=v;
	  		InsertAtCorrectPositionBackWard(arr,index,v,n);
	  	}
		
	}

	private static void InsertAtCorrectPositionBackWard(int[] arr, int index, int v,int n) {
		int temp=v;
		boolean flag=false;
		
		for(int i=index;i>0;i--)
		{   
			if(arr[i-1]>temp)
			{
			arr[i]=arr[i-1];
			}
			else
			{
				arr[i]=temp;
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			arr[0]=temp;
		}
		
	}

	private static void InsertAtCorrectPositionForward(int[] arr, int index, int v,int n) {
		
		int temp=v;
		boolean flag=false;
		
		for(int i=index;i<n-1;i++)
		{   
			if(arr[i+1]<temp)
			{
			arr[i]=arr[i+1];
			}
			else
			{
				arr[i]=temp;
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			arr[n-1]=temp;
		}
		
	}

	private static int findIndex(int[] arr, int u, int n) 
	{
		 int l=0;
		 int r=n-1;
		 while(l<r)
		 {
			 int mid=l+(r-l)/2;
			 if(arr[mid]==u)
				 return mid;
			 else if(arr[mid]>u)
			 {
				 r=mid-1;
			 }
			 else
			 {
				 l=mid+1;
			 }
		 }
	
		return 0;
	}

	private static int findMedian(int[] arr, int d) {
		if (d % 2 != 0) {
			int x = 0;
			int y = d - 1;
			int z = x + (y - x) / 2;
			return 2*arr[z];
		} else {
			int x = 0;
			int y = d-1;
			int z = x + (y - x) / 2;
//			System.out.println("z= " + z);
			int a = ((arr[z] + arr[z + 1]));
//			System.out.println("a= " + a);
			return a;

		}

	}
}
