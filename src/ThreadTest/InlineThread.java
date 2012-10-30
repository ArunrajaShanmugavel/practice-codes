package ThreadTest;

public class InlineThread {
	
	
	
	public static void main(String s[]){
		
		Thread a = new Thread(){
			public void run(){
					System.out.println("test");
				}
			};
			
		a.start();
	}
	

}
