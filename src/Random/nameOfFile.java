import java.util.Scanner;

public class nameOfFile {
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int x=s.nextInt();
	
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}

	}

}
