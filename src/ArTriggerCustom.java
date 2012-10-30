

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArTriggerCustom {
	
	public static void main(String s[])
	{
		stringParser();
	}

	public static void stringParser()
	{
		String s = "a,b";
		String[] s2 = s.split(",");
		
		for(int i=0;i<s2.length;i++)
		{
			System.out.println(s2[i]);
			triggerAR(s2[i]);
		}
		
		//triggerAR("VTRWV");
	}
	
	public static void triggerAR(String pin)
	{
		try
		{
			
			URL url;
			HttpURLConnection connection = null;
			String lResponseMessage = "";
			String targetURL = "http://staging.webchat.a-cti.com:8082/js/action/eventToTalkAction.do?";
			String urlParameters = "method=sendJSONRequest&open=submitClickToTalkForm&formName=TestScheduleForm&eventToTalkId=3005251315&generatedXML=<?xml version=\"1.0\" encoding=\"UTF-8\"?><form><formfield><label>Phone</label><value>8250000000</value></formfield><formfield><label>uniquepin</label><value>"+pin+"</value></formfield></form>";
			
			System.out.println( "Sending Request to:::::::::" +targetURL);
			// Create connection
			url = new URL( targetURL );
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod( "POST" );
			connection.setRequestProperty( "Content-Type" , "application/x-www-form-urlencoded" );
			connection.setRequestProperty( "Content-Length" , "" + Integer.toString( urlParameters.getBytes().length ) );
			connection.setRequestProperty( "Content-Language" , "en-US" );
			connection.setUseCaches( false );
			connection.setDoInput( true );
			connection.setDoOutput( true );
			// Send request
			DataOutputStream wr = new DataOutputStream( connection.getOutputStream() );
			wr.writeBytes( urlParameters );
			wr.flush();
			wr.close();
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader( new InputStreamReader( is ) );
			rd.close();
			lResponseMessage = connection.getResponseMessage();
			System.out.println("lResponseMessage is "+lResponseMessage);
		}
	catch(Exception e)
	{
		System.out.println("Problem in the code");
	}
	}
}
