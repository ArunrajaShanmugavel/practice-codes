package ThreadTest;

public class syncmain {
	
	/* Synchronsed method example */
	
	public static void main(String s[]) throws InterruptedException
	{
		syncobj obj = new syncobj();
		
		// Synchronised method example
		new ThreadCreator(obj,1).join();
		new ThreadCreator(obj,2).join();
		
		// ConcrrentModificationException creator
		new ThreadCreator(obj,3);
		Thread.sleep(2000);  // wait till the object is started to iterate
		System.out.println("adding to arraylist");
		obj.al.add(3);
	}

}
