
public class Topcoder {
	
	
	public static void main(String[] s)
	{
		Topcoder tc = new Topcoder();
		System.out.println("Will all but 1st params add to 1st param-"+tc.buy(10,2,41,2,2));
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

}
