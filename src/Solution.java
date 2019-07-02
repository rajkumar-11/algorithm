import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		String str = "my name is rajkumar and my name was arsenal";

		Map<String, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(str, " ");

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (map.containsKey(token)) {
				map.put(token, map.get(token) + 1);
			} else {
				map.put(token, 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}