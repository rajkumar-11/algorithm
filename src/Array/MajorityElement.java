package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4};
		int n = arr.length;

		// Function calling
		findMajority(arr, n);

	}

	private static void findMajority(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 1);

			}
		}
		int max = -1;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > n / 2)
				max = entry.getKey();

		}
		System.out.println("max= "+ max);

	}
}
