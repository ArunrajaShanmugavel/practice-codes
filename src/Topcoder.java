import java.util.Arrays;
import java.util.HashSet;


public class Topcoder {
	
	
	public static void main(String[] s)
	{
		Topcoder tc = new Topcoder();
		//System.out.println("Will all but 1st params add to 1st param-"+tc.buy(10,2,41,2,2));
		//tc.checkCharMatch();
		//System.out.println(tc.minDucks(new int[]{9,3,6,4}));
		//System.out.println(tc.getMinimum("o??x",9,4));
		//System.out.println(tc.train(new int[]{5,5}));
		//System.out.println(Arrays.toString(tc.find(100000,new int[]{100000})));
		System.out.println(tc.maxTurns(new int[]	{55, 52, 61, 204, 207, 54, 60, 202, 57, 58, 53, 210, 51, 59, 209, 205, 208, 201, 206, 211, 203, 56}));
		
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
				if((i & (1<<j))!=0) // determine add value of array based on true bits of i index
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
			return 1;
		else
		{
			if(numCrates % 2 == 0)
				return 2*numTrucks(numCrates/2,loadSize);
			else
				return numTrucks(numCrates/2,loadSize) + numTrucks(numCrates/2+1,loadSize);  //http://community.topcoder.com/stat?c=problem_statement&pm=6011
		}
	}
	
	//Greedy L1 problems
	
	// pronounce numbers from A to B sequentially - Find: minimal numbers missed  
	int minDucks(int[] ducks)
	{
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int a : ducks)
		{
			if(a<min)
				min = a;
			
			if(a>max)
				max = a;
		}
		
		return (max - (min-1)) - ducks.length;   //http://community.topcoder.com/stat?c=problem_statement&pm=11631
	}
	
	// Sorted Array Create from unsorted array by moving one value at a time - Find : Number of moves required on optimal solution for Worst case
	int solve(int[] T)
	{
		int moves = 0;
		for(int i=0;i<(T.length/2);i++)  // note: half the array comparison is enough
		{
			moves += T[T.length-i-1] - T[i];
		}
		return moves;   // http://community.topcoder.com/stat?c=problem_statement&pm=11336
	}
	
	// Fill '?' in string with 'o' or 'x' to make palindrome with minCost
	int getMinimum(String s, int oCost, int xCost)
	{
		char[] cArr = s.toCharArray();  
		int cost = 0; 
		int l = cArr.length;
		
		for(int i=0;i<l/2;i++)
		{
			if (cArr[i] == '?' && cArr[l-i-1]=='?')
			{
				cost += 2* ((oCost<xCost)?oCost:xCost);
			}
			else if(cArr[i] == '?' || cArr[l-i-1]=='?' )
			{
				cost += cArr[l-i-1]=='x'?xCost:oCost;
			}
			else if(cArr[i] != cArr[l-i-1])
				return -1;
		}
		
		if((l&1)==1) 
		{
			cost += (oCost<xCost)?oCost:xCost;
		}
		return cost;  //http://community.topcoder.com/stat?c=problem_statement&pm=11727
	}
	
	// Swap elements of the string such that  - http://apps.topcoder.com/wiki/display/tc/SRM+521  http://community.topcoder.com/stat?c=problem_statement&pm=11567
	
	
	// increase elems to common value
	int train(int[] attributes)
	{
		int max = Integer.MIN_VALUE , difference = 0;
		for(int i=0;i<attributes.length;i++)
		{	
			max = attributes[i]>max ? attributes[i] : max;
		}
		System.out.println("max - "+max);
		
		for(int i=0;i<attributes.length;i++)
		{
			difference += max - attributes[i];
		}
		
		return difference;  //http://community.topcoder.com/stat?c=problem_statement&pm=11279
	}
	
	// Easy http://community.topcoder.com/stat?c=problem_statement&pm=11151
	
	// TheProgrammingContestDivTwo TotalProbTime T - requiredTime - T1,T2.. compute penalty(total time spent) & points (number of probs solved)
	int[] find(int T, int[] requiredTime)
	{
		Arrays.sort(requiredTime);   // Optimization to pick smallest ones first
		
		int penalty = 0, points = 0, exp_time = 0;
		
		for(int i=0;i<requiredTime.length;i++)
		{
			//rem_time -= requiredTime[i];
			
			if ((exp_time +requiredTime[i])<=T)
			{
				exp_time +=requiredTime[i] ; penalty += exp_time ; points ++;  
			}
		}
		return new int[]{points,penalty};   //http://community.topcoder.com/stat?c=problem_statement&pm=11358
	}
	
	/**
	 * 
	 * Dynamic programming L1 problems
	 * 
	 * learning - range & sequences problem
	 * 
	 */
	int maxTurns(int[] cards)
	{
		Arrays.sort(cards); 
		int turns =0,i=0;
		
		for(i=0;i<cards.length-1;i++)
		{
			if(cards[i]!=0)
				turns++; 
			
			if(cards[i]+1==cards[i+1])
				cards[i+1]=0;
		}
		
		if(cards[i]!=0) 
			turns++;
		
		return turns;   //http://community.topcoder.com/stat?c=problem_statement&pm=11341
	}
	
}
