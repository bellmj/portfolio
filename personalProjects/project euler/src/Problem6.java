public class Problem6
{
    public static void main (String [] args)
    {
        int square = 0;
        int temp;
        int sum =0;
        int hundred[] = new int [100];
        for(int x = 0; x < 100; x++)
        {
            hundred[x] = (x+1);
        }
        for(int x:hundred)
        {   temp = x*x;
            square += temp;
        }
        for(int x:hundred)
        {
            temp = x;
            sum += temp;
        }
        System.out.println(Math.abs(square - (sum*sum) ));
    }
}
