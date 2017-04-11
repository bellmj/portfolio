

public class Euler49 {
	public static void main (String args[]){
		long sequence = 1;
		long x1 = 1000L;
		long x2 = x1 + sequence;
		long x3 = x2 + sequence;
		//boolean stop = true;
		while(sequence <= 3334){
			//System.out.println(sequence);
			while(x3 < 10000){
				if(arePermutations(x1,x2,x3)){
					//System.out.println(""+x1 + " " + x2+ " " + x3);
					if(arePrime(x1,x2,x3) && x1!= 1487){
						System.out.println("" + x1 + x2 + x3);
						//stop = false;
						break;
					}
				}
				//System.out.println(""+x1 + " " + x2+ " " + x3);
				x1++;
				x2 = x1 + sequence;
				x3 = x2 + sequence;
			}
			x1 = 1000L;
			x2 = x1 + sequence;
			x3 = x2 + sequence;
			sequence ++;
		}
		
		
	}
	static boolean arePrime(long x1,long x2, long x3){
		if(isPrime(x1)&&isPrime(x2)&isPrime(x3)){
			return true;
		}
		return false;
	}
	static boolean arePermutations(long x1,long x2,long x3){
		long a = 0;
		long b = 0;
		long c = 0;
		long d = 0;
		a = x1 / 1000;
		x1 = x1 % 1000;
		b = x1/ 100;
		x1 = x1 % 100;
		c = x1/10;
		x1 = x1 % 10;	
		d = x1;
		//System.out.printf(" %d %d %d %d\n",a,b,c,d);
		long a1 = 0;
		long b1 = 0;
		long c1 = 0;
		long d1 = 0;
		a1 = x2 / 1000;
		x2 = x2 % 1000;
		b1 = x2 / 100;
		x2 = x2 % 100;
		c1 = x2 / 10;
		x2 = x2 % 10;	
		d1 = x2;
		//System.out.printf(" %d %d %d %d\n",a1,b1,c1,d1);
		
		long a2 = 0;
		long b2 = 0;
		long c2 = 0;
		long d2 = 0;
		a2 = x3 / 1000;
		x3 = x3 % 1000;
		b2 = x3/ 100;
		x3 = x3 % 100;
		c2 = x3/10;
		x3 = x3 % 10;	
		d2 = x3;
		//System.out.printf(" %d %d %d %d\n",a2,b2,c2,d2);
		if(a + b + c + d == a1 + b1 + c1 + d1 && a1 + b1 + c1 +d1 == a2 +b2 + c2 + d2){
			if(((a == a1 || a == b1 || a == c1 || a == d1) && 
					(b == a1 || b == b1 || b == c1 || b == d1)&& 
					(c == a1 || c == b1 || c == c1 || c == d1)&&
					(d == a1 || d == b1 || d == c1 || d == d1)) &&
					(a1 == a2 || a1 == b2 || a1 == c2 || a1 == d2) &&
					(b1 == a2 || b1 == b2 || b1 == c2 || b1 == d2)&&
					(c1 == a2 || c1 == b2 || c1 == c2 || c1 == d2)&&
					(d1 == a2 || d1 == b2 || d1 == c2 || d1 == d2))
			return true;
		}
		return false;
	}
	static boolean isPrime(long n)
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


}
