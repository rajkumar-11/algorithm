import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GivenASequenceOfWordsPrintAllAnagramsTogether2 {
	public static void main(String args[]) {
		String wordArr[] = { "cat", "dog", "tac", "god", "act" };
		int size = wordArr.length;
		printAnagramsTogether(wordArr, size);
	}

	private static void printAnagramsTogether(String[] wordArr, int size)
	{
		int len = wordArr.length;
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < len; i++) 
		{
			Integer code = wordArr[i].hashCode();
			if (map.containsKey(code)) 
			{
				List<String> list = map.get(code);
				list.add(wordArr[i]);
				map.put(code, list);

			} else
			{
				List<String> list = new LinkedList<>();
				list.add(wordArr[i]);
				map.put(code, list);

			}

		}
		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) 
		{
			List<String> list = entry.getValue();
			System.out.println(list.toString());

		}

	}
}
