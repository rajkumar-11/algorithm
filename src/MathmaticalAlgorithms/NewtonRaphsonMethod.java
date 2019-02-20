
package MathmaticalAlgorithms;

public class NewtonRaphsonMethod 
{
	static final double EPSILON=0.001;
	
	static double func(double x)
	{
		return x*x*x-x*x+2;
		
	}
	static double derivFunc(double x)
	{
		return 3*x*x-2*x;
	}
	
	
  public static void main(String[] args) 
 {
  double x0=-20;
  
  newtonRaphson(x0);
	  
	  
	  
	  
}
private static void newtonRaphson(double x) 
{
	 double h=func(x)/derivFunc(x);	
	
	 while(Math.abs(h)>=EPSILON)
	 {
		 h=func(x)/derivFunc(x);
		 
		 x=x-h;
		 
	 }
	 System.out.println("the values of the root is "+Math.round(x*100)/100.0);
}
	
	
}
