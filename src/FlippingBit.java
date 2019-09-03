import java.util.Scanner;

public class FlippingBit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            long q = s.nextLong();

            long ans = 0;
            int pow = 0;
            while (pow<32) {
                long x = q % 2;
                ans += (Math.pow(2, pow) * (1 ^ x));
//                System.out.println(ans);
                q = q / 2;
                pow++;
            }
            System.out.println(ans);
        }


    }

}
