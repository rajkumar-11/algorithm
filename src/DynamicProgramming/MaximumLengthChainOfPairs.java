package DynamicProgramming;

import java.util.Arrays;

public class MaximumLengthChainOfPairs {
	public static void main(String[] args) {
		Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
		System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));

	}

	private static int maxChainLength(Pair[] arr, int length) {
		int[] value = new int[length];

		Arrays.fill(value, 1);

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i].a > arr[j].b && value[j] + 1 > value[i]) {

					value[i] = value[j] + 1;
				}

			}

		}

		for (int i = 0; i < length; i++) {
			System.out.print(value[i] + " ");
		}

		return 0;
	}
}

class Pair {
	int a, b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;

	}

}
