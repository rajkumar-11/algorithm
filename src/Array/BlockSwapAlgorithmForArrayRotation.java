package Array;

public class BlockSwapAlgorithmForArrayRotation 
{
public static void main(String[] args) 
{
	int arr[] = {1, 2, 3, 4, 5, 6, 7}; 
	
	arr=leftRotate(arr, 20, 7); 
	
	for(int i=0;i<7;i++)
	{
		System.out.print(arr[i]+" ");
	}
	
}

private static int[] leftRotate(int[] arr, int d, int n)
{
  int[] arr2=new int[n];
  
  if (d>n)
	  d=d%n;
  for(int i=d;i<n;i++)
  {
	  arr2[i-d]=arr[i];
	  
  }
  int x=n-d;
  
  for(int i=0;i<d;i++)
  {
	  arr2[i+x]=arr[i];
	  
  }
  return arr2;
	
}
}
