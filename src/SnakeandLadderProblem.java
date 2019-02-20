import java.util.LinkedList;
import java.util.Queue;

public class SnakeandLadderProblem {
	static class Qentry {
		int v;
		int dist;
	}

	public static void main(String[] args) {
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));

	}

	private static int getMinDiceThrows(int[] moves, int n) {
		Queue<Qentry> queue = new LinkedList<>();

		Qentry qentry = new Qentry();
		qentry.v = 0;
		qentry.dist = 0;

		boolean[] visited = new boolean[n];
		queue.add(qentry);

		while (!queue.isEmpty()) {

			qentry = queue.poll();
			
//			 System.out.println("here");

			if (qentry.v == n - 1)
				break;

			for (int i = 1; i <= 6 && i+qentry.v < n; i++)
			{
			 
				if (visited[i + qentry.v] == false) {
					Qentry temp = new Qentry();
					temp.v = qentry.v + i;
					temp.dist = qentry.dist + 1;

					if (moves[i + qentry.v] != -1)
						temp.v = moves[i + qentry.v];

					queue.add(temp);
				}

			}

		}

		return qentry.dist;
	}
}
