import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class PowerSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int r = s.nextInt();
		int count = 0;
		int limit = 0;
		List<Integer> list = new LinkedList<Integer>();
		for (int i = l; i <= r; i++) {
			if (isPower(i)) {
				count += 1;
//			   System.out.println("here");
			} else {
				boolean flag = false;
				for (int j = i - 1; j >= l && j>=limit; j--) {
//				sysotu
					if ((isPower(j))) {
//					System.out.println("j= "+j);
						if (i - j == 1) {
							count += 1;
							flag = true;
							break;
						} else {
//							System.out.println("i-j=" + (i - j));
							if (isPower(i - j)) {
								count += 1;
								flag = true;
								break;
							}
						}

					}

				}
				if (flag == false) {
					limit = i;
				}

			}

		}
		System.out.println(count);

	}

	static boolean isPower(int n) {
		if(n==1)
			return true;
		for (int x = 2; x <= Math.sqrt(n); x++) {
			int y = 2;

			double p = Math.pow(x, y);

			while (p <= n && p > 0) {
				if (p == n)
					return true;
				y++;
				p = Math.pow(x, y);
			}
		}
		return false;
	}

}
