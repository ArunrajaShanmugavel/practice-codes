
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Input from file Name-Sal, Sort them on salary , Output to a file
 * @author arun
 *
 */

public class BeanSorter {
	
	public static void main(String s[]) throws IOException
	{
		
		FileInputStream fis = new FileInputStream("/Users/arun/IdeaProjects/file-ip-test.txt");
		
		Scanner sc = new Scanner (fis, "UTF-8");
		
		ArrayList<bean1> al = new ArrayList<bean1>();
				
		log("Input from file:");
		while(sc.hasNextLine())
		{
			String s1;
			System.out.println(  s1 = sc.nextLine());
			String inArr[] = s1.split("-");
			al.add(new bean1(inArr[0],Integer.parseInt(inArr[1])));
		}
		
		Collections.sort(al,new BeanComparator() );
		
		FileOutputStream fos = new FileOutputStream ("/Users/arun/IdeaProjects/file-op-test.txt");
		
		OutputStreamWriter dos = new OutputStreamWriter (fos,"UTF-8");
		
		StringBuilder sb = new StringBuilder(); 
		
		for (bean1 b1: al){
			sb.append(b1.name+"-"+b1.sal+"\n");
		}
		
		log("\nSorted content to write to file:");
		log(sb.toString());
		
		dos.append(sb);
		
		dos.close(); sc.close();
		
	}
	
	static void  log(String s)
	{
		System.out.println(s);
	}

}

class bean1{
	
	String name;
	int sal;
	
	bean1(String name, int sal){
		this.name = name;
		this.sal = sal;
	}
	
}

class BeanComparator implements Comparator<bean1>
{
	
	public int compare(bean1 o1, bean1 o2) {
		
		if(o1.sal > o2.sal)
			return -1;
		else if (o1.sal < o2.sal)
			return 1;
		else
			return 0;
		
	}
	
}
