import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KnotsAndCrosses {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		// int countx = 0;
		// int counto = 0;

		for (int o = 0; o < t; o++) {

			int countx = 0;
			int counto = 0;

			int n = s.nextInt();

			int m = s.nextInt();

			int k = s.nextInt();

			s.nextLine();

			char[][] arr = new char[n][m];

			for (int i = 0; i < n; i++) {

				arr[i] = s.nextLine().replace(" ", "").toCharArray();
				// System.out.println(Arrays.toString(arr[i]));

			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < m; j++) {
					char x = arr[i][j];

					int cont = 1;
					for (int q = 1; q < k && q + i < n; q++) {
						if (arr[q + i][j] == x) {
							cont++;
						} else {
							break;
						}
					}
					if (cont == k) {
						if (x == 'x') {
							countx++;
						} else {
							counto++;
						}
					}
					cont = 1;

					for (int q = 1; q < k && q + j < m; q++) {
						if (arr[i][q + j] == x) {
							cont++;
						} else {
							break;
						}

					}
					if (cont == k) {
						if (x == 'x') {
							countx++;
						} else {
							counto++;
						}
					}
					cont = 1;

					for (int q = 1; q < k && i + q < n && j + q < m; q++) {
						if (arr[i + q][j + q] == x) {
							cont++;
						} else {
							break;
						}

					}
					if (cont == k) {
						if (x == 'x') {
							countx++;
						} else {
							counto++;
						}
					}
					cont = 1;

					for (int q = 1; q < k && i - q >= 0 && j + q < m; q++) {

						if (arr[i - q][j + q] == x) {
							cont++;
						} else {
							break;
						}
					}

					if (cont == k) {
						if (x == 'x') {
							countx++;
						} else {
							counto++;
						}
					}

				}

			}
			System.out.println(countx + " " + counto);

		}

	}
}
