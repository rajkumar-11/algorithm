
public class PetersonGraphProblem {

	static boolean adj[][];

	static char result[] = new char[100005];

	public static void main(String[] args) {
		adj = new boolean[10][10];

		adj[0][1] = adj[1][2] = adj[2][3] = adj[3][4] = adj[4][0] = adj[0][5] = adj[1][6] = adj[2][7] = adj[3][8] = adj[4][9] = adj[5][7] = adj[7][9] = adj[9][6] = adj[6][8] = adj[8][5] = true;

		String s = "ABBECCD";

		if (findthepath(s, s.charAt(0) - 'A') || findthepath(s, s.charAt(0) - 'A' + 5)) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}

	}

	private static boolean findthepath(String s, int j) {
		result[0] = (char) ('0' + j);

		for (int i = 1; i < s.length(); i++)
		{
			
//			System.out.println(s.charAt(i) - 'A' + 5);
			// System.out.println("j= " + j + " " + s.charAt(i));
			if (adj[j][s.charAt(i) - 'A'] == true||adj[s.charAt(i)-'A'][j]==true) {
				j = s.charAt(i) - 'A';
			} else if (adj[j][s.charAt(i) - 'A' + 5] == true||adj[s.charAt(i)-'A'+5][j]==true) {
				j = s.charAt(i) - 'A' + 5;

			} else
				return false;
			result[i] = (char) (j + '0');

		}

		return true;
	}

}
