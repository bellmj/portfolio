public class Problem2
{
    public static void main (String [] args)
    {
        int rsum = 0;
        int fib = 1;
        int nfib = 1;
        int temp;

        while(nfib < 4000000)
        {
            if(nfib % 2 == 0)
                rsum+= nfib;
            temp = fib + nfib;
            fib = nfib;
            nfib = temp;
        }
        System.out.println(rsum);

    }
}
