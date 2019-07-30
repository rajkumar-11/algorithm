package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeXOR 
{
public static void main(String[] args) 
{
  Scanner s= new Scanner(System.in);
  int q= s.nextInt();
  boolean[] primeArr= new boolean[8192];
	 Arrays.fill(primeArr,true);
	 primeArr[0]=false;
	 primeArr[1]=false;
  for(int y=0;y<q;y++)
  {
	  int n= s.nextInt();
	  Set<Integer> set= new LinkedHashSet<Integer>();
	  int[] arr= new int[4501];
	  for(int j=0;j<n;j++)
	  {
		  int x=s.nextInt();
		  set.add(x);
		  arr[x]++;
	  }
//	  System.out.println(Arrays.toString(arr));
//	  
	long mo=1000000007;
	 
	 for(int j=2;j*j<8192;j++)
	 {
		 if(primeArr[j]==true)
		 {
			 for(int k=j*2;k<8192;)
			 {
				 primeArr[k]=false;
				 k=k+j;
			 }
		 }
	 }
//	 System.out.println(Arrays.toString(primeArr));
	 long[][]FlagArr= new long[2][8192];
//	 int[] valueArr=
	 int flag=1;
	 
	 FlagArr[0][0]=1;
	 
	 for(int i=3500;i<=4500;i++)
	 {
		 for(int j=0;j<=8191;j++)
		 {
			 if(arr[i]==0)
			 {
				 FlagArr[flag][j]=FlagArr[1-flag][j];
			 }
			 else
			 {
				 FlagArr[flag][j]=((FlagArr[1-flag][j]*(arr[i]/2+1)%mo)%mo+(FlagArr[1-flag][j^i]*((arr[i]+1)/2)%mo)%mo)%mo;
			 }
			 
		 }
		 flag=1-flag;
	 }
	 long ans=0;
	 flag=1-flag;
	 for(int i=0;i<8192;i++)
	 {
		 if(primeArr[i])
		 {
			 ans=(ans+FlagArr[flag][i])%mo;
		 }
	 }
	 System.out.println(ans);
	  
	  
  }
	
}
}
