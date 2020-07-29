import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        String string = s.next();
        String decodedString = "";
        int temp = 0;
        char[] chArr = new char[n];
        int l = string.length();
        int index = n - 1;
        for (int i = 0; i < k; i++) {
            int x = (string.charAt(l - 1 - i) - 48) ^ temp;
//            System.out.println("x= " + x);
            if(index>=0) {
                chArr[index] = (char) (x + 48);
            }
//           } System.out.println("chArr[index]= " + chArr[index]);
            index--;

            temp = x ^ temp;
        }

        for (int i = k; i < l - k + 1; i++)
        {
            int x = chArr[index + k] - 48;
            temp = x ^ temp;
            int y = (string.charAt(l - 1 - i) - 48) ^ temp;

            chArr[index] = (char) (y + 48);
            index--;
            temp = y ^ temp;
        }
//        System.out.println("l-n= "+(l-n));

        System.out.println(String.valueOf(chArr).substring(n+k-string.length()-1));


    }

}
