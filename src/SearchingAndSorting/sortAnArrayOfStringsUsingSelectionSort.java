package SearchingAndSorting;

public class sortAnArrayOfStringsUsingSelectionSort 
{
public static void main(String[] args) 
{
  String[] strarr={"GeeksforGeeks", "Practice.GeeksforGeeks","GeeksQuiz"};
    selectionsort(strarr);
	System.out.println("Sorted array");

	for (String i : strarr) {
		System.out.print(i + " ");
	}
  
	
	
}

private static void selectionsort(String[] strarr) {

	
	for (int i = 0; i < strarr.length; i++) {
		String min = strarr[i];
		int index = i;
		for (int j = i + 1; j < strarr.length; j++) {

			if (strarr[j].compareTo(min)<0) {
				min = strarr[j];
				index = j;

			}

		}
		String temp = strarr[i];
		strarr[i] = strarr[index];
		strarr[index] = temp;

		for (String x : strarr) {
			System.out.print(x + " ");
		}
		System.out.println();

	}

	
	
	
	
}
}
