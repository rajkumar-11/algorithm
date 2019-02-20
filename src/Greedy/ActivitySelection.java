package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
	public static void main(String[] args) {
		Activitiy arr[] = { new Activitiy(5, 9), new Activitiy(1, 2), new Activitiy(3, 4), new Activitiy(0, 6),
				new Activitiy(5, 7), new Activitiy(8, 9) };
		int n = arr.length;

		System.out.println("Maximum activites that can be performed is  " + printMaxActivities(arr, n));

	}

	private static String printMaxActivities(Activitiy[] arr, int n) {
		Arrays.sort(arr, new ActivityCompare());

		int i = 0;

		System.out.println(arr[0].start + " " + arr[0].finish);

		for (int j = 1; j < n; j++) {
			if (arr[j].start > arr[i].finish) {
				System.out.println(arr[j].start + " " + arr[j].finish);
				i = j;

			}

		}

		return null;
	}

}

class ActivityCompare implements Comparator<Activitiy> {

	@Override
	public int compare(Activitiy a1, Activitiy a2) {
		// TODO Auto-generated method stub
		return a1.finish - a2.finish;
	}

}

class Activitiy {
	int start, finish;

	public Activitiy(int start, int end) {
		this.start = start;
		this.finish = end;

	}

}