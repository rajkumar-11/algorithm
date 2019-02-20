package SearchingAndSorting;

public class BubbleSort 
{
public static void main(String[] args) 
{
	 
     int arr[] = {64, 34, 25, 12, 22, 11, 90};
     bubbleSort(arr);
     System.out.println("Sorted array");
  
     for(int i:arr)
     {
    	 System.out.print(i+" ");
     }
    	
	
	
}

private static void bubbleSort(int[] arr)
{
	for(int i=0;i<arr.length;i++)
	{
		
		for(int j=1;j<arr.length-i;j++)
		{
			if(arr[j-1]>arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
				
			}
			
		}
		
	}
	
	
	
}	

}
