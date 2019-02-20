package Random;

public class StartEnd 
{
public static void main(String[] args) 
{
 int start=34,end=45;
 int i=0,j=0,k=0;
 
  for(int m=start;m<=end;m++)
  {
	  if(gcd(m,9381)>2)
	  {
		  i=i+m;
		  k=k+m;
	  }
	  else
	  {
		  j=j+m;
		  k=k+m;
		   	
	  }
	  
	  
  }
		System.out.println("i= "+i+"j= "+j+"k= "+k);	 
 
	
	
}

private static int gcd(int a, int b) {
	 if(b==0)
		  return a;
		
		
		return gcd(b,a%b);
}
}
