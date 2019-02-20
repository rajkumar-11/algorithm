package Misc;

import java.util.PriorityQueue;

public class ConnectnRopesWithMinimumCostHuffman {
	public static void main(String[] args) {

		int len[] = { 4, 3, 2, 6 };
		int size = len.length;
		System.out.println("Total cost for connecting" + " ropes is " + minCost(len, size));

	}

	private static int minCost(int[] len, int size) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < size; i++) {
			queue.add(len[i]);

		}
		int res = 0;

		while (queue.size() > 1) {
			int x = queue.poll();
			int y = queue.poll();

			res += x + y;
			queue.add(x + y);

		}

		return res;
	}

}
