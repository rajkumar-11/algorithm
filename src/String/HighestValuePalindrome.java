package String;

import java.util.Arrays;
import java.util.Scanner;

public class HighestValuePalindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		String string = s.next();
		int l = string.length();
		boolean flag = false;
		boolean isPossible = true;
		int count = 0;
		char[] charArr = string.toCharArray();
		// System.out.println("n= " + n + " k= " + k);

		boolean[] visited = new boolean[l];

		for (int i = 0; i < l / 2; i++) {
			if (count > k) {
				isPossible = false;
				// System.out.println(-1);
				break;
			}
			if (charArr[i] == '0' && flag == false) {
				// System.out.println("here");
				if (charArr[l - i - 1] != '0') {
					charArr[i] = charArr[l - 1 - i];
					visited[i] = true;
					count++;
				} else {
					charArr[i] = charArr[l - 1 - i] = '9';
					visited[i] = visited[l - 1 - i] = true;
					count += 2;
				}

			} else {
				flag = true;
				if (charArr[i] == charArr[l - 1 - i]) {
					continue;
				} else {
					if (charArr[i] == '9') {
						charArr[l - 1 - i] = '9';
						// visited[l-1-i]=true;
					} else {
						charArr[i] = charArr[l - 1 - i];
						visited[i] = true;
					}
					count++;
				}
			}

		}

		if (count > k) {
			System.out.println(-1);
		} else if (count == k) {
			printArr(charArr, n);
		} else {
			// System.out.println("here");
			printArr(convert(charArr, visited, k, count, l), n);

		}

	}

	private static void printArr(char[] charArr, int n) {

		for (int i = 0; i < n; i++) {
			System.out.print(charArr[i]);
		}
	}

	private static char[] convert(char[] charArr, boolean[] visited, int k, int count, int n) {
		int remaining = k - count;
		// System.out.println("remaining= "+remaining);
		// System.out.println(Arrays.toString(charArr));
		for (int i = 0; i <= n / 2; i++) {
			if (remaining < 0) {
				return charArr;
			}
			if (charArr[i] != '9') {
				if (visited[i] == true) {
					if (remaining >= 1) {
						charArr[i] = charArr[n - 1 - i] = '9';
						remaining = remaining - 1;
					}

				} else {
					if (remaining >= 2) {
						charArr[i] = charArr[n - 1 - i] = '9';
						remaining = remaining - 2;
					}
				}

			}

		}
		if (remaining == 1) {
			charArr[n / 2] = '9';
		}

		return charArr;
	}

}
