package com.ea.Framework.Utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/*
 * Internal Logging mechanism
 */
public class LogUtil {

    //File Format for log name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);
    private BufferedWriter bufferedWriter = null;

    //Create Log File
    public void CreateLogFile()
    {
        try
        {
            File dir = new File("C:\\TestNG_Java\\FrameWork_3.0\\Logs");
            if(!dir.exists())
                dir.mkdir();
            File logfile = new File(dir+"\\"+fileNameFormat+".txt");
            FileWriter fileWriter = new FileWriter(logfile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

        }
        catch(Exception e){
            e.getStackTrace();

        }
    }
    //Write messege within the logs
    public void Write(String message)
    {
        try
        {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("["+dateFormat+"]"+message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        {

        }
    }
    
    public static String TimeStamp ()
    {
    	//Get the current date and time of execution.
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String timeStamp = formatter.format(date);// get timestamp
	    return timeStamp.replace("/", "").replaceAll(" ", "_").replaceAll(":", "_");
    }

}
