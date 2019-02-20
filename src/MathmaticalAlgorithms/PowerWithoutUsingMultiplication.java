package MathmaticalAlgorithms;

public class PowerWithoutUsingMultiplication 
{
	public static void main(String[] args) 
    { 
        System.out.println(pow(5, 5)); 
    }

	private static int  pow(int a, int b) 
	{
	 
		if(b==0)
			return 1;
		
		int increament=a;
		
		
		int sum=0;
		
		for(int i=1;i<b;i++)
		{
			sum=0;
		 for(int j=0;j<a;j++)
		 {
			 sum+=increament;
			 
		 }
			increament=sum;	
			
		}
		
		
		
		return sum;
	} 
	
	

}
