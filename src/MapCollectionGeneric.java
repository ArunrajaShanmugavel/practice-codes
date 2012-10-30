import java.util.HashMap;
import java.util.Map;


public class MapCollectionGeneric 
{
	public static void main(String s[])
	{
		System.out.println("test");
		Map<String,Object> m = new  HashMap<String,Object>();
		m.put("k2",new Integer(3));
		System.out.println(m.get("k2"));
		
		Map m2 = new  HashMap<String,String>();
		m2.put("k","v");
		m2.put("k2",new Integer(3));
		System.out.println(m2.get("k"));
		System.out.println(m2.get("k2").getClass());
	}
}
