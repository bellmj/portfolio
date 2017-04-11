public class Problem3
{
    public static void main (String [] args)
    {
        MyUtil prime = new MyUtil();
        long x = 1;
        long primeFactor = 0;
       long NUMBER = 600851475143L;
        char p = 'n';
        long done = 1;

        while(x < NUMBER)
        {
            if(NUMBER % x == 0)
            {   p = 'n';

                    if(prime.isPrime(x) )
                        p = 'y';


                if(p == 'y')
                {

                        primeFactor = x;
                        done *= x;//this multiplies the prime factors together
                    System.out.println(x);

                }
            }
            if(done == NUMBER)//if all of the prime factors multiplied
            //together equal the number then the largest prime factor is last numnber multiplied
                break;


            x++;
        }
        System.out.println("the largest prime factor is " + primeFactor);

    }
}
