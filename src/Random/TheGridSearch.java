import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TheGridSearch {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int q = 0; q < t; q++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				String string = s.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.valueOf(string.charAt(j) - '0');
				}
			}
			int a = s.nextInt();
			int b = s.nextInt();
			int[][] pattern = new int[a][b];
			for (int i = 0; i < a; i++) {
				String string = s.next();
				for (int j = 0; j < b; j++) {
					pattern[i][j] = Integer.valueOf(string.charAt(j) - '0');
				}
			}

			boolean flag = false;
			String y = pattern[0].toString();
			for (int i = 0; i < n - a + 1; i++) {
				List<Integer> list = findIndexes(arr[i], pattern[0], m, b);

				if (list.size() > 0) {
					// System.out.println("here i= "+i);
					for (int k = 0; k < list.size(); k++) {
						int j = list.get(k);
						// System.out.println("j= " + j);
						flag = ifPossible(arr, pattern, i, j, n, m, a, b);
						if (flag) {
							System.out.println("YES");
							break;
						}

					}
				}
				if (flag) {
					break;
				}

			}
			if (flag == false) {
				System.out.println("NO");
			}
		}
	}

	private static boolean ifPossible(int[][] arr, int[][] pattern, int i, int j, int n, int m, int a, int b) {
		boolean flag = true;
		// int o = 1;
		// int p = 0;

		for (int x = 1; x < a; x++) {
			for (int y = 0; y < b; y++) {
				if (arr[i + x][y + j] != pattern[x][y]) {
					return false;
				}
			}
			// o++;
		}
		// System.out.println("kjhafdlkjaslkjfhadsljfhalkjhfdasdlfjlkdsf");
		return true;
	}

	private static List<Integer> findIndexes(int[] list1, int[] list2, int m, int b) {
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < m - b + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < b; j++) {
				if (list1[i + j] == list2[j]) {
					continue;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				list.add(i);
			}

		}

		return list;
	}

}
