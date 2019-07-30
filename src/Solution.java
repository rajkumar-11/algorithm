import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'getMinimumMoves' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY identification as parameter.
	 */

	public static int getMinimumMoves(List<Integer> identification) {
		// int[] arr= identification.toArray();

		int n = identification.size();

		// int[] arr2=new int[n];

		int[] arr2 = new int[n];
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr2[i] = identification.get(i);
			arr[i] = arr2[i];
		}

		Arrays.sort(arr);

		int prevIndex = findIndex(arr2, arr[0], n - 1);
		int count = 0;
		// System.out.println("prevIndex= "+prevIndex);

		for (int i = 1; i < n; i++) {
			int index = findIndex(arr2, arr[i], n - 1);
			// System.out.println("index= "+index);

			if (index < prevIndex) {
				count++;
				prevIndex = n - 1;
			} else {
				prevIndex = index;

			}

		}
		return count;

	}

	public static int findIndex(int[] arr2, int value, int n) {
		// int l=0;
		// int r=n;
		// System.out.println("value= "+value);
		// System.out.println("r= "+r);
		// System.out.println("arr = "+Arrays.toString(arr2));

		// while(l<=r)
		// {
		// int mid=(r-l)/2;

		// if(arr2[mid]==value)
		// {
		// return mid;
		// }
		// else if(arr2[mid]<value)
		// {
		// l=mid+1;
		// }
		// else
		// {
		// r=mid-1;
		// }
		// System.out.println("mid = " + mid + " l= " + l + " r= " + r);

		// }

		// return -1;
		for (int i = 0; i <= n; i++) {
			if (arr2[i] == value) {
				return i;
			}
		}
		return -1;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int identificationCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> identification = new ArrayList<>();

		for (int i = 0; i < identificationCount; i++) {
			int identificationItem = Integer.parseInt(bufferedReader.readLine().trim());
			identification.add(identificationItem);
		}

		int result = Result.getMinimumMoves(identification);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
