package String;

import java.util.Scanner;

public class StrongPassword {
	public static void main(String[] args)
	{ 
      Scanner s= new Scanner(System.in);
      int n=s.nextInt();
      String specialChars="!@#$%^&*()-+";
      
      String string= s.next();
//      System.out.println("string= "+string);
      int[] arr= new int[256];
      for(int i=0;i<n;i++)
      {
//    	  System.out.println((int)string.charAt(i));
    	  arr[(int)string.charAt(i)]++;
    	  
      }
      int count=0;
      boolean flag=false;
      for(int i=48;i<=57;i++)
      {
    	  if(arr[i]!=0)
    	  {
    		  flag=true;
    		  break;
    	  }
    	  
      }
      if(flag==false)
      {
    	  count++;
      }
      else
      {
    	  flag=false;
      }
      for(int i=65;i<=90;i++)
      {
    	  if(arr[i]!=0)
    	  {
    		  flag=true;
    		  break;
    	  }
    	  
      }
      if(flag==false)
      {
    	  count++;
      }
      else
      {
    	  flag=false;
      }
	
      for(int i=97;i<=122;i++)
      {
    	  if(arr[i]!=0)
    	  {
    		  flag=true;
    		  break;
    	  }
    	  
      }
      if(flag==false)
      {
    	  count++;
      }
      else
      {
    	  flag=false;
      }
      for(int i=0;i<specialChars.length();i++)
      {
    	  if(arr[specialChars.charAt(i)]!=0)
    	  {
    		  flag=true;
    		  break;
    	  }
    	  
      }
      if(flag==false)
      {
    	  count++;
      }
      else
      {
    	  flag=false;
      }
      System.out.println(Math.max(count,6-n));
		
		  
		
	}
}
