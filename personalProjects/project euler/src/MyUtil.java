/**
 * 
 * @author Matt Bell
 *@
 */
public class MyUtil
    {
         
    
         MyUtil()                     
        {
               
        }
         /**
          * 
          * @param Takes in a long to check if Prime or not
          * @return True, False if the Param is prime or not
          */
     boolean isPrime(long n)
    {
            if(n==1){
                return false;
            }
            else if(n==2){
                return true;
            }
            else if (n%2==0) 
            {
                return false;
            }
            else{
                for(long i=3;i*i<=n;i+=2) 
                {
                    if(n%i==0)
                    {
                        return false;
                    }
                }
                return true;
            }
        }
     /**
      * 
      * @param x Takes in a 2d array and will display it 
      */
      static void display2dArray(int x[][])
       {
           for(int row=0;row<x.length;row++)
           {
               for(int column=0;column< x[row].length;column++)
               {
                    System.out.print(x[row][column]+"\t");
               }
               System.out.println();
           }
       }
	  	/**
	  	 * 
	  	 * @param n Takes the number of the term of  the Fibonacci sequence that you want
	  	 * @return the nth term of the Fibonacci sequence only accurate up to the 71st term
	  	 */
	  	public static long fib(long n){
	  		    if(n == 0)
	  		        return 0;
	  		    else if(n == 1)
	  		      return 1;
	  		   else
	  		      return fib(n - 1) + fib(n - 2);
	  		}

      /**
       * 
       * @param l Takes in a long type
       * @return returns the number of divisors of the param
       */
      static int numberOfDivisors(long l){
    	  int $ = 0;
    	  for(int x = 1;x<=Math.sqrt(l);x++){
    		  if(l%x==0){
    			  $+= 2;
    		  }
    	  }
    	  return $;
      }
}
    
             

    