public class Problem1
{
    public static void main (String [] args)
    {   int y = 0;
      for(int counter = 0;counter<1000;counter++)
      {
          if(counter % 3 == 0 || counter % 5 ==0)
                y += counter;
        }
        System.out.println(y);
    }
}
