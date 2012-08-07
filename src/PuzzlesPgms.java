
public class PuzzlesPgms {
	
	//http://stackoverflow.com/questions/11538824/java-program-divisible-by-three-without-using-modulus
	
	public static void main(String[] args) {
	    String number = "12";
	    System.out.println("test val : "+(0-'0')+","+((0-'0')-'0')+",'0' is "+('0'));
	    int sum = 0;
	    for (char c : number.toCharArray()) {
	        sum = sum - (0 - c) - '0';
	        while (sum >= 3) {
	            sum -= 3;
	        }
	    }
	    System.out.print("divisible by 3? ");
	    System.out.println(sum == 0);
	}
}


//convert to negative integer
//