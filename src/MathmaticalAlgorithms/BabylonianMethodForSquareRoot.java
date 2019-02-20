package MathmaticalAlgorithms;

public class BabylonianMethodForSquareRoot 
{
public static void main(String[] args) 
{ 
	int n = 50; 
    
    System.out.printf ("Square root of "
            + n + " is " + squareRoot(n)); 
	 
	
}

private static double squareRoot(int n) 
{
	float x=n;
	float y=1;
	
	double e=0.000001;
	
//	while(x-y>e)
//	{
//		x=(x+y)/2;
//		y=n/x;
//	
//	}
 
	while(x > y) 
    { 
        x = (x + y) / 2; 
        y = n / x; 
    } 
	
	
	
	return x;
}
}
