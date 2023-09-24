package Random;

import java.util.Random;


public class C1 implements I1, I2 // won't compile
{
    public static void main(String[] args)
    {
       new C1().print();

    }

    @Override
    public void print() {
      I1.super.print();

    }

//    @Override
//    public void print() {
//
//    }
}