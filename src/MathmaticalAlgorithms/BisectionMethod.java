package MathmaticalAlgorithms;

public class BisectionMethod
{
static final float Epsilon=(float)(0.01);

static double func(double x)
{
	return x*x*x-x*x+2;
}
public static void main(String[] args) 
{
 double a=-200,b=300;
 
  bisection(a,b);
	
	
}
private static void bisection(double a, double b)
{
if(func(a)*func(b)>=0)
{
	System.out.println("You have not assumed right a and b");
	
	return;
}
double c=a;
while((b-a)>=Epsilon)
{
	c=(a+b)/2;
	
	if(func(c)==0.0)
		break;
	else if (func(c)*func(a)<0)
		b=c;
	else
		a=c;
	
	
	
}
System.out.printf("The value of root is %.4f",c);


	
}

}
