package ThreadTest;

public class ThreadCreator extends Thread
{
	syncobj a;
	
	int ThrdCnt=0;
	public ThreadCreator(syncobj a,int ThrdCnt)
	{
		this.a = a;
		this.ThrdCnt = ThrdCnt;
		this.start();
	}
	
	public void run()
	{
		if(ThrdCnt==1||ThrdCnt==2)
		{	
			a.delayAndPrint(ThrdCnt);
			new syncobj().delayAndPrint2(ThrdCnt);
		}
		
		if(ThrdCnt==3)
			a.iterateArrayList();
	}
}
