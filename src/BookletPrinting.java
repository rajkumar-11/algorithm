import java.util.Scanner;

public class BookletPrinting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

//		int x=n/4;
		int nofBlankPages = 0;
		if (n % 4 != 0) {
			nofBlankPages = ((n / 4) + 1) * 4 - n;
		}
//		System.out.println(nofBlankPages);

		int m = (n + nofBlankPages) / 4;
		int y = 0;
//		System.out.println("numberOfBlanks=" + nofBlankPages);
		
		if(n==0)
		{
			System.out.println("s" + 1 + ",front," + "blank," + "blank");
			System.out.println("s" + 1 + ",back," + "blank," + "blank");
			
			
		}
		else
		{
		for (int i = 1; i <= m; i++) {
			int x = (i - 1) * 2 + 1;
			if (nofBlankPages > 0) {
				System.out.println("s" + i + ",front," + "blank," + x);
				nofBlankPages -= 1;

			} else { 	
				System.out.println("s" + i + ",front," + (n - y) + "," + x);
				y += 1;
//				nofBlankPages-=1;

			}
			if (nofBlankPages > 0) {
				if (m == 1 && nofBlankPages == 2) {
					System.out.println("s" + i + ",back," + "blank" + ",blank");
				} else {
					System.out.println("s" + i + ",back," + (x + 1)+ ",blank");
					nofBlankPages -= 1;
				}

			} else {
				System.out.println("s" + i + ",back," + (x + 1) + "," + (n - y));
				y = y + 1;

//				nofBlankPages-=1;

			}

		}
		}

	}

}
