package DynamicProgramming;

import java.util.Arrays;

public class BoxStacking {
	public static void main(String[] args) {
		Boxh[] arr = new Boxh[4];
		arr[0] = new Boxh(4, 6, 7);
		arr[1] = new Boxh(1, 2, 3);
		arr[2] = new Boxh(4, 5, 6);
		arr[3] = new Boxh(10, 12, 32);

		System.out.println("The maximum possible " + "height of stack is " + maxStackHeight(arr, 4));

	}

	private static int maxStackHeight(Boxh[] arr, int n) {
		Boxh[] boxRot = new Boxh[3 * n];

		for (int i = 0; i < n; i++) {
			boxRot[3 * i] = new Boxh(arr[i].h, Math.max(arr[i].w, arr[i].d), Math.min(arr[i].w, arr[i].d));
			boxRot[(3 * i) + 1] = new Boxh(arr[i].w, Math.max(arr[i].h, arr[i].d), Math.min(arr[i].h, arr[i].d));
			boxRot[(3 * i) + 2] = new Boxh(arr[i].d, Math.max(arr[i].h, arr[i].w), Math.min(arr[i].h, arr[i].w));

		}

		for (int i = 0; i < 3 * n; i++) {
			boxRot[i].area = boxRot[i].w * boxRot[i].d;

		}
		Arrays.sort(boxRot);

		int[] arrh = new int[3 * n];

		for (int i = 0; i < 3 * n; i++) {
			arrh[i] = boxRot[i].h;

		}

		for (int i = 0; i < 3 * n; i++) {
			// arrh[i]=0;

			for (int j = 0; j < i; j++) {
				if (boxRot[i].d > boxRot[j].d && boxRot[i].w > boxRot[j].w && boxRot[i].h + arrh[j] > arrh[i]) {

					arrh[i] = boxRot[i].h + arrh[j];

				}

			}

		}

		for (int i = 0; i < 3 * n; i++) {
			System.out.print(arrh[i] + " ");

		}

		return 0;
	}

}

class Boxh implements Comparable<Boxh> {
	int h, w, d, area;

	public Boxh(int h, int w, int d) {
		this.h = h;
		this.w = w;
		this.d = d;

	}

	@Override
	public int compareTo(Boxh o) {

		return this.area - o.area;
	}

}