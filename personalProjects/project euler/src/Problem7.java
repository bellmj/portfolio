public class Problem7
{
    public static void main (String [] args)
    {
        long counter = 0;
        long y = 0;
        MyUtil prime = new MyUtil();
        while(counter != 10001)
        {
            for(long x = y;x>=Integer.MIN_VALUE;x++)
            {
                if(prime.isPrime(x))
                {
                    counter++;
                    y = x;
                    if(counter == 10001)
                    {
                        break;
                    }
                }
            }
        }
        System.out.println(y);
    }
}
