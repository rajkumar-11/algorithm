

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BitLand {
	
	public static void main(String[] args) 
	{
	 Scanner s= new Scanner(System.in);
	 int n=s.nextInt();
	 int[] arr= new int[n];
	 
	 for(int i=0;i<n;i++)
	 {
		 arr[i]=s.nextInt();
	 }
	 int t=s.nextInt();
	 
	 for(int i=0;i<t;i++)
	 {
		 int l=s.nextInt();
		 int r=s.nextInt();
		 int result=1;
		Map<Integer, Integer>map= new HashMap<Integer, Integer>();
		 
		 for(int x=l;x<=r;x++)
		 {
			 if(map.containsKey(arr[x-1]))
			 {
//				 System.out.println("value= "+map.get(arr[x-1]));
				 result=result*map.get(arr[x-1]);
				 
			 }
			 else
			 {
			 int y=function(arr[x-1]);
			 map.put(arr[x-1], y);
			 result=result*y;
			 }
			 
		 }
		 System.out.println(result%(1000000007));
		 
		 
	 }
	 
		
	}

	private static int function(int x) 
	{
        
     for(int i=2;i<=x/2;i--)
     {
    	 if(x%i==0)
    		 return x/i;
    		 
     }
		
		return 1;
	}

}
