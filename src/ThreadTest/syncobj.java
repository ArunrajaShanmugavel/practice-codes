package ThreadTest;

import java.util.ArrayList;
import java.util.Iterator;

public class syncobj {
	
	ArrayList al = new ArrayList();
	
	syncobj()
	{
		al.add(1);
	}
	
	synchronized void delayAndPrint(int cnt)
	{
		try{
		System.out.print("Thread:"+cnt+",Mehod:1-Am in");
		Thread.sleep(2000);
		System.out.println(", After 2 sec out");
		}
		catch(Exception e)
		{
			System.out.println("Error-"+e);
		}
	}
	
	synchronized void delayAndPrint2(int cnt)
	{
		try{
		System.out.print("Thread:"+cnt+",Mehod:2-Am in");
		Thread.sleep(2000);
		System.out.println(", After 2 sec out");
		}
		catch(Exception e)
		{
			System.out.println("Error-"+e);
		}
	}
	
	void iterateArrayList() 
	{
		try
		{
			System.out.println("starting iterate");
			Iterator b= al.iterator();
			while(b.hasNext())
			{
				try 
				{
					Thread.sleep(5000);
					b.next();
				} catch (InterruptedException e) 
				{
					System.out.println(e);
				}
			}
			System.out.println("ending iterate");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
