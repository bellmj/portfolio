public class Problem5
{
    public static void main (String [] args)
    {
        int numbers[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int tuna = 0;
        for(int y = 1; y != -1;y++)
        {
            for(int x: numbers)
            {
                if(y%x != 0)
                {
                    tuna = 0;
                    break;
                }
                tuna = 1;
            }
            if(tuna == 1)
            {
                System.out.println(y);
                break;
            }
        }
    }
}
