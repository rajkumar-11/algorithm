package Random;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Print print=new Print();

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        t1.start();
        t2.start();
        t3.start();



    }

}

 class Print
 {
     public synchronized  void printA() throws InterruptedException {
         for(int i=0;i<=10;i++) {
             System.out.print("A"+" ");
             this.wait();
             this.notifyAll();
         }

     }
     public synchronized void printB() throws InterruptedException {
         for(int i=0;i<=10;i++) {
             System.out.print ("B"+" ");
             this.wait();
             this.notifyAll();
         }

     }
     public synchronized void printC() throws InterruptedException {
         for(int i=0;i<=10;i++) {
             System.out.print("C"+" ");
             this.wait();
             this.notifyAll();
         }

     }



 }



class QWE {
    int id;
    String name;

    public QWE(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
