import java.util.concurrent.*;
import java.util.concurrent.locks.*;
/*
1)Java:
Write a Java Program to swap two numbers without using the third variable. 

Write code in such a way that no deadlock should occur. 
The trick to solving this problem is acquiring resources 
in order and release them in reverse order,
e.g. first acquire resource R1 and only if you have got R1 to go for R2. T
his way, you can avoid deadlock.

Output:
num1: 121 num2: 232
num1: 232 num2: 121
*/

public class NumberManipulator{
    NumberManipulator(){}

    ExecutorService executor = Executors.newFixedThreadPool(2);
   
    ReadWriteLock lock = new ReentrantReadWriteLock();

    int num1 = 121 , num2  = 232; 
   

    public static void main(String... args){
        //NumberManipulator.swapTwoNumber(121, 232);
        NumberManipulator m = new NumberManipulator();
        

        m.doTry();
        m.stopExcutor();
    }

    public static void swapTwoNumber(int num1, int num2){
        System.out.println("num1: " + num1 + " num2: " + num2);
        num1 =  num1 + num2; 
        num2 = num1 - num2;
        num1 = num1 - num2; 

        System.out.println("num1: " + num1 + " num2: " + num2);

        
        
    }
   
    public void doTry(){
        executor.submit(() -> {
            lock.writeLock().lock();
            try {

                swapTwoNumber(num1, num2);
 
            } finally {
                lock.writeLock().unlock();
            }
        });

        //stop(executor);

    }



    public void stopExcutor(){
        executor.shutdown();
    }
   
}

