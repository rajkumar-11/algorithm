package Misc;

public class PrintAllPairsOfAnagramsInAGivenArrayOfStrings
{
public static void main(String[] args) 
{

    String arr[] = {"geeksquiz", "geeksforgeeks",
                    "abcd", "forgeeksgeeks", 
                    "zuiqkeegs"};
    int n = arr.length;
    findAllAnagrams(arr, n);
	
	
}

private static void findAllAnagrams(String[] arr, int n)
{
	int[][] charVal= new int[arr.length][26];
	
	
  for(int i=0;i<arr.length;i++)
  {
	  for(int j=0;j<arr[i].length();j++)
	  {
//		  System.out.println("arr[i].length  "+arr[i].length()+"  j= "+j);
		  charVal[i][arr[i].charAt(j)-'a']++;
		  
		  
	  }
	
  }
  for(int i=0;i<arr.length-1;i++)
  {
	  for(int j=i+1;j<arr.length;j++)
	  {
		  if(arr[i].length()!=arr[j].length())
			  continue;
		  else
		  {
			  boolean flag=true;
			  for(int k=0;k<26;k++)
			  {
				  if(charVal[i][k]==charVal[j][k])
					  continue;
				  else
				  {
					  flag=false;
					  break;
				  }
			  }
			  if(flag==true)
			  {
				  System.out.println(arr[i]+"  is anagram of "+arr[j]);
				  
			  }
			 
			  
			  
			  
		  }
		  
	  }
	  
  }
  
	
	
}
}
