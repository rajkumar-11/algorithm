package Misc;

public class ProgramToEvaluateSimpleExpressions {
	public static void main(String[] args) {
		String expr1 = "1+2+++";
		int res = evaluate(expr1);

		if (res == -1)
			System.out.println("Invalid expression");
		else
			System.out.println(expr1 + " = " + res);

//		System.out.println(Integer.valueOf('0'));

	}

	private static int evaluate(String expr) {
		boolean preva = true;
		int x=0,y=0;
        int sum=0;
		
		for (int i = 0; i < expr.length(); ) {
			if (expr.charAt(i) >= 48 && expr.charAt(i) <= 57)
			{
//				  x=y;
				  y = Integer.valueOf(expr.charAt(i)-'0');
//				  System.out.println("y= "+y);
				  sum=y;
				  i++;
				  continue;
			}
			if(expr.charAt(i)=='+')
			{
				if(i+1==expr.length() || !(expr.charAt(i+1) >= 48 && expr.charAt(i+1) <= 57))
					return -1;
//				System.out.println("expr.charAt(i+1)= "+Integer.valueOf(expr.charAt(i+1)));
				 x =  Integer.valueOf(expr.charAt(i+1)-'0');
//				 sum=y;
				 sum+=x;
//				 System.out.println("sum= "+sum);
				 i=i+2;
				
//				sum=sum+x;
			}
			else if(expr.charAt(i)=='-')
			{
				if(i+1==expr.length() || !(expr.charAt(i+1) >= 48 && expr.charAt(i+1) <= 57))
					return -1;
				 x =Integer.valueOf(expr.charAt(i+1)-'0');
//				 sum=y;
				 sum-=x;
				 i=i+2;
//				 System.out.println("sum= "+sum);
				
//				sum=sum+x;
			}
			else if(expr.charAt(i)=='*')
			{
				if(i+1==expr.length() || !(expr.charAt(i+1) >= 48 && expr.charAt(i+1) <= 57))
					return -1;
				 x =Integer.valueOf(expr.charAt(i+1)-'0');
//				 System.out.println("x= "+x+" y="+y);
//				 sum=y;
				 sum*=x;
				 i=i+2;
//				 System.out.println("sum= "+sum);
				
//				sum=sum+x;
			}
			else if(expr.charAt(i)=='/')
			{
				if(i+1==expr.length() || !(expr.charAt(i+1) >= 48 && expr.charAt(i+1) <= 57))
					return -1;
				 x = Integer.valueOf(expr.charAt(i+1)-'0');
				 sum=y;
				 sum/=x;
				 i=i+2;
//				 System.out.println("sum= "+sum);
				 
				
//				sum=sum+x;
			}
			else
			{
				return -1;
			}

		}

		return sum;
	}
}
