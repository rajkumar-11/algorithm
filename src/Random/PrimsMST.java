import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PrimsMST {
	public static void main(String[] args) {
		// 9 */
		int V = 5;
		int[][] graph ={{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                {0, 0, 2, 0, 0, 0, 6, 7, 0} 
               }; 

		// Print the solution
		primMST(graph);

		// return 0;
	}

	private static void primMST(int[][] graph) {

		int[] value = new int[9];

		boolean[] visited = new boolean[9];

		Arrays.fill(visited, false);

		Arrays.fill(value, Integer.MAX_VALUE);
		value[0] = 0;

		int v = 0;
		int[] parent = new int[9];
		parent[0] = -1;

		LinkedList<Integer> list = new LinkedList<>();

		while (v < 9) {
			int index = getMin(value, visited);
			visited[index] = true;
			System.out.println("index= " + index);
			for (int i = 0; i < 9; i++) {
				if (graph[index][i] != 0 && graph[index][i]+value[index] < value[i]) 
				{
					value[i] = graph[index][i]+value[index];
					parent[i] = index;

				}

			}

			for (int i = 0; i < 9; i++) {
				System.out.print(value[i] + " ");
			}
			System.out.println();

			list.add(index);

			v++;

		}

		for (int i = 1; i < 9; i++) {
			System.out.println(i + " -> " + parent[i] + "  with weight " + graph[i][parent[i]]);

		}

	}

	private static int getMin(int[] value, boolean[] visited) {
		int min_index = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < 9; i++) {
			if (value[i] < min && visited[i] == false) {

				min = value[i];
				min_index = i;

			}

		}

		return min_index;
	}
}
