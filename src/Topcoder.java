
public class Topcoder {
	
	
	public static void main(String[] s)
	{
		Topcoder tc = new Topcoder();
		//System.out.println("Will all but 1st params add to 1st param-"+tc.buy(10,2,41,2,2));
		tc.checkCharMatch();
	}
	
	// recursion
	
	//bit masking
	public String buy(int price, int b1, int b2, int b3, int b4)
	{
		int[] b={b1,b2,b3,b4};
		for(int i=0;i<16;i++)
		{
			int sum=0;
			for(int j=0;j<4;j++)
			{
				if((i & (1<<j))!=0) // determine add list based on true bits 
				{
					sum += b[j];
				}
			}
			if(sum==price) return "POSSIBLE";
		}
		return "IMPOSSIBLE";  		//http://community.topcoder.com/stat?c=problem_statement&pm=10860
	}
	
	int[] derSeq(int[] a,int n)
	{
		int[] b = new int[a.length-1];
		
		if(n==0)
			return a;
		
		for(int i=0;i<a.length-1;i++)
		{
			b[i]=a[i+1]-a[i];
		}
		return derSeq(b,n-1);
	}
	
	public int numTrucks(int numCrates, int loadSize)
	{
		if (numCrates <= loadSize)
		{
			return 1;
		}
		else
		{
			if(numCrates % 2 == 0)
				return 2*numTrucks(numCrates/2,loadSize);
			else
				return numTrucks(numCrates/2,loadSize) + numTrucks(numCrates/2+1,loadSize);  //http://community.topcoder.com/stat?c=problem_statement&pm=6011
		}
	}
	
	// return max of n after k swaps of elements
	public int findMax(int n,int k)
	{
		if(k==0) return n;
		else if (n==-1) return -1;
		else
		{
			return findMax	(swapToPossibleMax(n),k-1);
		}
	}
	
	int swapToPossibleMax(int n)
	{
		char[] c =  Integer.toString(n).toCharArray();
		int m_idx = -1;
		char max=0;
		
		if(c.length==1)
			return -1;
		
		//choosing the max elem other than first one
		for(int i=1;i<c.length;i++)
		{
			if(c[i]>max)
			{
				max = c[i];
			  	m_idx = i;
			}
		}
		
		if(max > c[0])
		{
			
			// swap 1 st and max elem
			char tc = c[0];
			c[0] = c[m_idx];
			c[m_idx] = tc;
			
		}
		else 
		{
			// swap final 2 elems
			char tc = c[c.length-2];
			c[c.length-2] = c[c.length-1];
			c[c.length-1] = tc;
		}
		
		if( c[0]==0)
			return -1;
		
		return Integer.parseInt(s);
	}
	
	public void checkCharMatch(){
		System.out.println('1'+1);
	}

}
