
public class Test2 
{
 private boolean flag=true;
 
 public Test2()
 {
	 (new Inner()).test();
 }
 
 public void sample()
 {
	 System.out.println("Sample");
 }
 public static void main(String[] args) {
	 
	new Test2();
}
 class Inner
 {
	 void test()
	 {
		 if(Test2.this.flag)
		 {
			 sample();
		 }
	 }
	 
 }
 
	
	
}
