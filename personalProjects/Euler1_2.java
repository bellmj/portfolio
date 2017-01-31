import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Euler 1: " + euler1());
        System.out.println("Euler 2: " + euler2());
    }

    /**
     * This method is the solution to the Project Euler problem 1
     * The question prompt is as follows:
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     * @return the sum of the multiples of 3 or 5 below 1000
     */
    private static long euler1(){
        long returnSum = 0;
        for(int t = 3; t < 1000; t += 3){
            returnSum += t;
        }
        for(int f = 5; f < 1000; f += 5){
            if(f % 3 != 0){
                returnSum += f;
            }
        }
        return returnSum;
    }

    /**
     * This method is the solution to the Project Euler problem 2.
     * The question prompt is as follows:
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
     *
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     *
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     * @return the sum of the even terms in the Fibonacci sequence under 4 million
     */
    private static long euler2(){
        final int TOP_LIMIT = 4000000;
        int x = 1;
        int y = 2;
        long sumOfEvens = 0;
        while(y < TOP_LIMIT){
            int swap;
            swap = y;
            if(y % 2 == 0){
                sumOfEvens += y;
            }
            y = x + y;
            x = swap;
        }
        return sumOfEvens;
    }


}