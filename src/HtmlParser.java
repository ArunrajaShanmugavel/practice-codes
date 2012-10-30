import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;


public class HtmlParser {
	
	public static void main(String st[]) throws IOException
	{
		/*FileReader fr = new FileReader("http://kural.muthu.org/kural.php");*/
		
		URL u = new URL ("http://kural.muthu.org/kural.php?pid=2");
		
//		URL u = new URL ("http://cinekadal.blogspot.in/");
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("/Users/arun/Hack/temp/tamil-op.txt")));
		
		String s;
		while( (s = br.readLine()) !=null)
		{
			System.out.println(s);
			dos.writeBytes(s);
		}
			
	}

}
