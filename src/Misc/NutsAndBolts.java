package Misc;

public class NutsAndBolts {
	public static void main(String[] args) {
		char nuts[] = { '@', '#', '$', '%', '^', '&' };
		char bolts[] = { '$', '%', '&', '^', '@', '#' };

		matchNutAndbolts(nuts, bolts, 0, 5);

		for (char C : nuts) {
			System.out.print(C + " ");
		}
		System.out.println();

		 for (char C : bolts) {
		 System.out.print(C + " ");
		 }

	}

	private static void matchNutAndbolts(char[] nuts, char[] bolts, int low, int high) {

		if (low < high)
		// System.out.println("low= " + low + " high= " + high);
		{
			int pivot = partition(nuts, low, high, nuts[high]);
			// System.out.println("pivot= " + pivot);
			 partition(bolts, low, high, nuts[pivot]);
			matchNutAndbolts(nuts, bolts, low, pivot - 1);
			matchNutAndbolts(nuts, bolts, pivot + 1, high);
		}

	}

	private static int partition(char[] arr, int low, int high, char pivot) {
		int i = low;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot)
			{
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			} else if (arr[j] == pivot) {
				char temp = arr[j];
				arr[j] = arr[high];
				arr[high] = temp;
				j--;

			}
		}

		char temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;

		return i;
	}
}
