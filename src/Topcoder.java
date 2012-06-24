import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;


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
//		System.out.println(tc.maxTurns(new int[]	{55, 52, 61, 204, 207, 54, 60, 202, 57, 58, 53, 210, 51, 59, 209, 205, 208, 201, 206, 211, 203, 56}));
		//System.out.println(tc.find("abdfhdyrbdbsdfghjkllkjhgfds"));
		//System.out.println(tc.decompose("neotowheret",new String[]{"one", "two", "three", "there"}));
		System.out.println(tc.numPlaylists(2,0,3));
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
	
	/**
	 * Return least possible added Palindrome string
	 * Complexity n^2
	 * TODO: The described solution of the problem has a complexity of O(n^2) and works very fast when n ² 50. Find a solution for this problem that will work for n ² 100,000 (it should have a complexity of O(n * log n) or even O(n)).
	 */
	
	public int find(String s) 
	{
		for (int i=0;i<s.length();i++)
		{
			String tmp = s;
			for(int j=i-1;j>=0;j--)
			{
				tmp += s.charAt(j);
			}
			
			if(isPalin(tmp))
			{
				return tmp.length();
			}
		}
		return 0;
	}
	
	public boolean isPalin(String s)
	{
		int n = s.length();
		for(int i=0;i<n/2;i++)
		{
			if(s.charAt(i) != s.charAt(n-i-1))
				return false;
		}
		return true;
	}
	
	/**
	 * TODO: L1 problems Easy recursion based problem http://community.topcoder.com/stat?c=problem_statement&pm=10240
	 */
	
	int decompose1(String sentence, String[] validWords)
	{
		for (int i=0,base=0;i<sentence.length();i++)
		{
			CharSequence t = sentence.charAt(i)+"";
			char tc = sentence.charAt(i);
			
			for(int j=0,k;j<validWords.length;j++)
			{
				int cost = 0, mincost = Integer.MAX_VALUE;
				
				for(k=0;k<validWords[j].length();k++)
				{
					t = sentence.charAt(i+k)+"";
					if(validWords[i].contains(t))
					{
						if(j+1!=i)
						{
							cost++;
						}
					}
					else
						break;
				}
				if(cost < mincost )
				{
					mincost = cost;
					base += k;
				}
			}
			i += base;  
		}
		return 0;
	}
	
	// DP L2
	// TODO: Learn for C++ http://community.topcoder.com/stat?c=problem_solution&rm=298124&rd=12183&pm=8692&cr=144400
	// Problem: return minimum cost of creating words from possible set of words (//http://community.topcoder.com/stat?c=problem_statement&pm=8692&rd=12183&rm=298124&cr=144400)
	
	
	public int decompose(String sentence, String[] validWords) { 
		// for each element in sentence
		// try each possible words & set the state value at dp[i]
		int n = sentence.length();
		int [] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=0;i<n;i++){
			for(String s : validWords ){
				if( dp[i]<Integer.MAX_VALUE){
				System.out.println("I am in i,word-"+i+","+s);
					// length constraint & does possible string matches
				if(i+s.length()<=n && can(sentence.substring(i, i+s.length()),s)){
					// set the state to minimum of possible cost till now
					dp[i+s.length()] = Math.min(dp[i+s.length()],dp[i]+cost(sentence.substring(i, i+s.length()),s));
					System.out.println("dp["+(i+s.length())+"]="+dp[i+s.length()]);
				}
				}
			}
		}
		if(dp[n]==Integer.MAX_VALUE) return -1;
		return dp[n];    
	}
	
	boolean can(String s1,String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}

	int cost(String s1,String s2){
		// if chars do not match inc the count & return it
		int cost=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i))  cost++;
		}
		return cost;
	}
	
	/**
	 * Problem - Checker Game 2 players return Answer for "Will first player wins ?"
	 * Key - Parity of Total number of moves if odd => YES else NO
	 * http://community.topcoder.com/stat?c=problem_statement&pm=11791 
	 */
	public String getWinner(String board) { 
		int n = board.length(),parity=0;
		for(int i=0;i<n;i++){
			if(board.charAt(i)=='o') parity += n-i-1;
		}
		if(parity % 2 == 1) return "YES";
		return "NO";
	}
	
	// TODO: NoRepeat Playlist
	// Problem : N songs , M intermediate songs before repeating a song, Find: Number of possible playlists
	
	int N,M,P;
	long numPlaylists(int N, int M, int P)
	{
		this.N = N;
		this.M = M;
		this.P = P;
		return countDiffPlaylistPossibilities(1,0,N);
		//return 0;
	}
	
	int countDiffPlaylistPossibilities(int pos,int played,int toPlay)
	{
		System.out.println("pos-"+pos+",played-"+played+",toPlay-"+toPlay);
		if(pos==P)
			return (toPlay == 0 )?1:0;
		
		int possible_cnt = 0;
		
		if(toPlay > 0)
			possible_cnt = possible_cnt + (countDiffPlaylistPossibilities(pos+1,played+1,toPlay-1)) * toPlay;
		
		if(played > M)
			possible_cnt = possible_cnt +(countDiffPlaylistPossibilities(pos+1, played, toPlay)) * (played - M);
		
		System.out.println("possible_cnt-"+possible_cnt);
		
		return (possible_cnt);
			
	}
	long countPlaylists(int position, int XS, int YS) {
		  // the playlist is full
		  if (position == P)
		    return YS == 0 ? 1 : 0; // check the Completeness rule
		  
		  long result = 0;
		  // use the song from Y - there are YS possibilities on which song to play
		  if (YS > 0)
		    result += countPlaylists(position+1, XS+1, YS-1) * YS;
		  // use the song from X - there are (XS-M) possibilities on which song to play 
		  if (XS > M)
		    result += countPlaylists(position+1, XS, YS) * (XS-M); 
		  return result ;
		}
	
}
