class Aq
{
    void m1()
    {
        System.out.println("In m1 A");
    }
}
class Bq extends Aq
{
    void m1()
    {
        System.out.println("In m1 B");
    }
    void m2()
    {
        System.out.println("In m2 B");
    }
}
public class Test11 {

    public static void main(String[] args) {
        Aq a=new Bq();
        a.m1();
    }
}