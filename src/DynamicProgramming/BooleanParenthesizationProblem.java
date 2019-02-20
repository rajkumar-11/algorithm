package DynamicProgramming;

public class BooleanParenthesizationProblem {
	public static void main(String[] args) {
		char symbols[] = { 'T', 'T', 'F', 'T' };
		char operators[] = { '|', '&', '^' };

		int n = symbols.length;

		System.out.println(countParenthesis(symbols, operators, n));

	}

	private static int countParenthesis(char[] symbols, char[] operators, int n) {
		int[][] F = new int[n][n];
		int[][] T = new int[n][n];

		for (int i = 0; i < n; i++) {
			T[i][i] = (symbols[i] == 'T') ? 1 : 0;
			F[i][i] = (symbols[i] == 'F') ? 1 : 0;

		}

		for (int gap = 1; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {
				T[i][j] = F[i][j] = 0;

				for (int g = 0; g < gap; g++) {
					int k = i + g;

					int Tik = T[i][k] + F[i][k];
					int Tkj = T[k + 1][j] + F[k + 1][j];

					if (operators[k] == '&') {
						T[i][j] += T[i][k] * T[k + 1][j];
						F[i][j] = (Tik * Tkj - T[i][k] * T[k + 1][j]);

					}

					if (operators[k] == '|') {
						F[i][j] += F[i][k] * F[k + 1][j];
						T[i][j] += (Tik * Tkj - F[i][k] * F[k + 1][j]);

					}

					if (operators[k] == '^') {
						T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
						F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];

					}

				}

			}

		}

		return T[0][n - 1];
	}
}
