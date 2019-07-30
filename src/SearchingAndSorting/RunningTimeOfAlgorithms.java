package SearchingAndSorting;

import java.util.Scanner;

public class RunningTimeOfAlgorithms {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int count=0;

		for(int i=1;i<=n-1;i++)
		{
			int temp=arr[i];
			boolean flag=false;
			for(int j=i;j>=1;j--)
			{
				if(arr[j-1]>temp)
				{
					arr[j]=arr[j-1];
					count+=1;
				}
				else
				{
					arr[j]=temp;
					flag=true;
					break;
				}
				
			}
			if(flag==false)
			{
				arr[0]=temp;
			}
			
		}
		System.out.println(count);
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
