import java.util.HashMap;
import java.util.Map;

public class GivenAStringFindItsFirstNonRepeatingCharacter {
	
	static final int NO_OF_CHARS=256;
	
	static Map<Character,CountIndex>map=new HashMap<Character,CountIndex>(NO_OF_CHARS);
	
	public static void main(String[] args) {

		String str = "geeksforgeeks";
		int index = firstNonRepeating(str);

		System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " + " or string is empty"
				: "First non-repeating character is " + str.charAt(index));

	}

	private static int firstNonRepeating(String str) {
		getCharCountArray(str);
		
		int result=Integer.MAX_VALUE;
		
		for(int i=0;i<str.length();i++)
		{
			if(map.get(str.charAt(i)).count==1 && result>map.get(str.charAt(i)).index)
			{
				result=map.get(str.charAt(i)).index;
			}
			
			
		}
		

		return result;
	}

	private static void getCharCountArray(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				map.get(str.charAt(i)).incCount();
			}
			else{
				map.put(str.charAt(i),new CountIndex(i));
			}
		}
		

	}
}
class CountIndex
{
	int count,index;
	
	public CountIndex(int index)
	{
		this.count=1;
		this.index=index;
		
	}
	public void incCount()
	{
		
		this.count++;
	}
	
	
	
}