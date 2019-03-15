package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Element implements Comparable<Element> {
	int number, count;

	public Element(Integer key, Integer value) {
		this.number = key;
		this.count = value;
	}

	@Override
	public int compareTo(Element o) {

		return o.count - this.count;
	}

}

public class sortElementsByFrequency 
{
	public static void main(String[] args)
	{
		int arr[] = {5,5,2,8,5,6,8,8};

		int l = arr.length;

		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < l; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);

			} else {
				map.put(arr[i], 1);
			}

		}
		int length = map.size();
		List<Element> elements = new LinkedList<>();
		int i = 0;

		for (Map.Entry<Integer, Integer> key : map.entrySet()) {
			System.out.println("key= " + key.getKey() + " value= " + key.getValue());
			elements.add(new Element(key.getKey(), key.getValue()));
			i += 1;

		}

		// Arrays.sort(elements, new Comparator<Element>()
		// {
		// @Override
		// public int compare(Element e1, Element e2)
		// {
		// return e2.count - e1.count;
		// }
		//
		// });
		Collections.sort(elements);

		for (int j = 0; j < length; j++)
            {
				int v = elements.get(j).count;
				int x = elements.get(j).number;

			for (int k = 0; k < v; k++) {
				System.out.print(x + " ");
			}

		}

	}
}
