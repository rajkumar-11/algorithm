package BitAlgorithm;

public class DetectIfTwoIntegersHaveOppositeSigns {
	public static void main(String[] args) {
		int x = -100, y = -100;
		if (oppositeSigns(x, y) == true)
			System.out.println("Signs are opposite");
		else
			System.out.println("Signs are not opposite");

	}

	private static boolean oppositeSigns(int x, int y) {

//		if ((x ^ y) < 0)
//			return true;
//
//		return false;
		
		 return (((x ^ y) >> 63)& 1)==1?true:false; 
	}
}
