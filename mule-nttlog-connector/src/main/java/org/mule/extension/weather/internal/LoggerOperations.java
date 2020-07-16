package org.mule.extension.weather.internal;

import java.sql.Timestamp;
import java.io.FileWriter;  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;


import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class LoggerOperations {
	
	enum Priority1 {
	    INFO,
	    DEBUG,
	    WARN,
	    ERROR,
	    TRACE
	  }

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
	/**
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config LoggerConfiguration configuration, @Connection LoggerConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
  }**/

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String NTTLogger(@Config LoggerConfiguration configuration, @Connection LoggerConnection connection,@Optional(defaultValue="Add Data here") String Data,
		  @Optional(defaultValue="Add Information here") String Information,@Optional(defaultValue="INFO") String Priority,@Optional(defaultValue="#[correlationId]") String correlationId) {
	  LoggerConnectionProvider ls = new LoggerConnectionProvider();
	  
	 String DataFlag= configuration.DataFlag();
	 String InformationFlag= configuration.InformationFlag();
	 String AppName=configuration.AppName();
	 String AppVersion=configuration.AppVersion();
	 String Env=configuration.Environment();
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 
	 String logs="";
	/*  System.out.println("kunal");
	  System.out.println(configuration.getConfigId());
	 
	  System.out.println("appname");
	  System.out.println(configuration.AppName());
	  System.out.println("appversion");
	  System.out.println(configuration.AppVersion());
	  System.out.println("DataFlag");
	  System.out.println(configuration.DataFlag());
	  System.out.println("InformationFlag");
	  System.out.println(configuration.InformationFlag());
	  
	  System.out.println(correlationId + Data + Information + Priority + "aaaaaaaaaaaaa");
	  System.out.println( Priority +"\n"+ "{ \"correlationId\""+ ":" + "\"" +correlationId +"\"," + "\"Message\"" + ":" + "\"" + Data + "\"" + "}");
	  if(DataFlag.equals("true")) 
	  {System.out.println("data no,info no");}
	  */
	  if(DataFlag.equals("false") && InformationFlag.equals("false") ) 
	 {
		 //System.out.println("data false,info false");
		 return("");
	 }
	  else
		 if(DataFlag.equals("true") && InformationFlag.equals("true")) 
		 {
			// System.out.println("data true,info true");
			 logs = "{\r\n" + "\"" + Priority +  "\"" +":"  +"  {\r\n" + 
			 		"\"CorrelationId\"" + " :" +  "\"" + correlationId +"\", \r\n" + 
			 		"\"Data\"" + " :" +  "\"" + Data +"\", \r\n" + 
			 		"\"Information\"" + " :" +  "\"" + Information +"\", \r\n" + 
			 		"\"Priority\"" + " :" +  "\"" + Priority +"\", \r\n" + 
			 		"\"ApplicationName\"" + " :" +  "\"" + AppName +"\", \r\n" + 
			 		"\"ApplicationVersion\"" + " :" +  "\"" + AppVersion +"\", \r\n" + 
			 		"\"Environment\"" + " :" +  "\"" + Env +"\", \r\n" + 
			 		"\"Timestamp\"" + " :" +  "\"" + timestamp +"\" \r\n" + 
			 			" }\r\n}";
			 System.out.println(logs);
			 
		 }
		 else 
			 if(DataFlag.equals("true") && InformationFlag.equals("false")) 
			 {
				// System.out.println("data true,info false");
				 logs ="{\r\n" + "\""  + Priority +  "\""+ ":"  +"  {\r\n" + 
				 		"\"CorrelationId\"" + " :" +  "\"" + correlationId +"\", \r\n" + 
				 		"\"Data\"" + " :" +  "\"" + Data +"\", \r\n" + 
				 		"\"Priority\"" + " :" +  "\"" + Priority +"\", \r\n" + 
				 		"\"ApplicationName\"" + " :" +  "\"" + AppName +"\", \r\n" + 
				 		"\"ApplicationVersion\"" + " :" +  "\"" + AppVersion +"\", \r\n" + 
				 		"\"Environment\"" + " :" +  "\"" + Env +"\", \r\n" + 
				 		"\"Timestamp\"" + " :" +  "\"" + timestamp +"\" \r\n" + 
				 			" }\r\n}";
				 // System.out.println( Priority +"\n"+ "{ \"correlationId\""+ ":" + "\"" +correlationId +"\"," + "\"Message\"" + ":" + "\"" + Data + "\"" + "}");
				 System.out.println(logs);
			 }
			 else
	  if(DataFlag.equals("false") && InformationFlag.equals("true")) 
		 {
			// System.out.println("data false,info true");
			 logs = "{\r\n" + "\"" + Priority +  "\"" + " :" + "{\r\n" + 
			 		"\"CorrelationId\"" + " :" +  "\"" + correlationId +"\", \r\n" + 
			 		"\"Information\"" + " :" +  "\"" + Information +"\", \r\n" + 
			 		"\"Priority\"" + " :" +  "\"" + Priority +"\", \r\n" + 
			 		"\"ApplicationName\"" + " :" +  "\"" + AppName +"\", \r\n" + 
			 		"\"ApplicationVersion\"" + " :" +  "\"" + AppVersion +"\", \r\n" + 
			 		"\"Environment\"" + " :" +  "\"" + Env +"\", \r\n" + 
			 		"\"Timestamp\"" + " :" +  "\"" + timestamp +"\" \r\n" + 
			 			" }\r\n}";
			 // System.out.println( Priority +"\n"+ "{ \"correlationId\""+ ":" + "\"" +correlationId +"\"," + "\"Message\"" + ":" + "\"" + Data + "\"" + "}");
			 System.out.println(logs);
		 }
	 
	 
	 
	 
	  return PrintLogs("\r\n" + logs);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String PrintLogs(String logs) 
  {
	  
		  BufferedWriter bw = null;
			FileWriter fw = null;
			//String FILENAME = "C:\\Users\\192520\\Desktop\\AAP1\\aa.txt";	
			String FILENAME = "NTTLogger.txt";	
			
			
			try {

				String data = logs;

				File file = new File(FILENAME);

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);

				bw.write(data);

				System.out.println("Done");

			} catch (IOException e) 
			{

				e.printStackTrace();

			} 
			finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}}
    return logs  ;
  }
}
