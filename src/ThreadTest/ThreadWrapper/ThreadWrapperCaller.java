package ThreadTest.ThreadWrapper;

public class ThreadWrapperCaller {
	
	public static void main(String s[])
	{
		new ThreadWrapperCaller().callThreadWrapper();
	}
	
	public void callThreadWrapper()
	{
		// test() method of this object is called with a new Thread
		new ThreadWrapper(this.getClass().getName(), "test");  // this.getClass().getName() gives the full qualified Class Name
	}
	
	public void test()
	{
		System.out.println("I am printed by ThreadWrapper using Reflection API");
	}

}
