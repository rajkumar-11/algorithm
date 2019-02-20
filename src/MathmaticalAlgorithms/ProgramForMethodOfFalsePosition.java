package MathmaticalAlgorithms;

public class ProgramForMethodOfFalsePosition {
	static int MAX_ITER = 1000000;

	public static void main(String[] args) {
		double a = -200, b = 300;
		regulaFalsi(a, b);

	}

	static double func(double x) {
		return x * x * x - x * x + 2;

	}

	private static void regulaFalsi(double a, double b) {
		if (func(a) * func(b) >= 0) {
         System.out.println("You have not assumed right a and bs");
			return;
		}
     double c=a;
     
     for(int i=0;i<MAX_ITER;i++)
     {
    	 c=(a*func(b)-b*func(a))/(func(b)-func(a));
    	 
    	 if(func(c)==0)
    		 break;
    	 
    	 else if(func(c)*func(a)<0)
    	    b=c;
    	 else
    		 a=c;
    		 
    	 
     }
		System.out.println("The vlaue of root is "+(int)(c));
		
	}
}
