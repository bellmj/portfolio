public class Problem4
{
    public static void main (String [] args)
    {
        int num;
        int temp = 0;//temp allows me to find the largest palanidrome

        for(int digit = 999;digit > 0; digit--)
        {
            for(int digit2 = 999;digit2 >0; digit2--)
            {
              num = digit * digit2;
              String s = "" + num;
              int n = s.length();
              String str="";
              for(int i = n - 1; i >= 0;i--)
              str=str+s.charAt(i);
              if(str.equals(s))
              {
                if(num > temp)//this if says that is the palindrome is larger than the last palindrome set it equal to temp
                    temp = num;
                break;
              }

            }
        }
        System.out.println(temp);
    }
}
