public class Problem10{
    public static void main (String [] args){
        long adder = 0;
        MyUtil prime = new MyUtil();
        for(long x = 0;x<2000000;x++){
            if(prime.isPrime(x)){
                adder += x;
            }
        }
        System.out.println(adder);
    }
}
