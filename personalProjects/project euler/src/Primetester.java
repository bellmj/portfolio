import java.util.*;
public class Primetester{
    public static void main (String [] args){
      
		Scanner scan = new Scanner(System.in);
        MyUtil prime = new MyUtil();
        System.out.println("enter a number to check for primeness");
        long x = scan.nextLong();
        scan.close();
        System.out.println( prime.isPrime(x));
    }
}