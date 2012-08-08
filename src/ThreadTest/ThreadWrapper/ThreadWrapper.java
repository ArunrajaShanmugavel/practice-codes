package ThreadTest.ThreadWrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ThreadWrapper extends Thread {
	
	String clsName;
	String mtdName;
	
	public ThreadWrapper(String clsName,String methodName)
	{
		this.clsName = clsName;
		this.mtdName = methodName;
		this.start();
	}
	
	public void run()
	{
		try 
		{
			// Wrapper for Threaded calling
			
			System.out.println(this.clsName+","+this.mtdName);
			Class<?> cls = Class.forName(this.clsName);
			System.out.println("Class is "+cls);
			Method[] mtds = cls.getMethods();
			System.out.println("Methods are "+Arrays.deepToString(mtds));
			Method mtd = cls.getMethod(this.mtdName);
			System.out.println("mtd is "+mtd);
			mtd.invoke(cls.newInstance(),null);
			
			//Runnable - Adding implementation methods on initialisation
			//Extends Thread - Adding implementation by overriding certain methods
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
