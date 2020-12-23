import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Rope {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			list.add(x);
		}
		int k = s.nextInt();
		List<Integer> l = getTheList(list, k);

	}

	private static List<Integer> getTheList(List<Integer> ropes, int k) {
		List<Integer> list = new ArrayList<>();
		int rem = k;
		int index = 0;
		int n = list.size();
		while (rem > 0 && index < n) {
			int maxIndex = index;
			int max = ropes.get(index);

			for (int i = index; i <= n - rem; i++) {
				if (max < ropes.get(i)) {
					max = ropes.get(i);
					maxIndex = i;
				}
			}

			// list.add(max);
			// System.out.println("rem= " + rem);
			// System.out.println("index= " + index+" maxIndex= "+maxIndex+"
			// n-rem = "+(n-rem));

			for (int i = index; i < maxIndex; i++) {
				list.add(ropes.get(i));
			}

			rem = rem - (maxIndex - index);
			index = maxIndex + 1;

		}

		return list;

	}
}
