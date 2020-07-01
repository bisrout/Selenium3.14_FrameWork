package com.ea.Framework.Utilities;
/*
 * Reporting Data table if the source to be fetch from DB after storing the result
 */
import java.sql.Connection;
import java.util.Hashtable;

public class ReportingUtil {
	
	//Method to insert details to the "sp_CreateTestCycleID" table created in SQL Server Management Studio
    public static void CreateTestCycle(Connection connection)
    {

        //Params
        Hashtable table = new Hashtable();
        table.put("AUT", "ExecuteAutoamtionWebApp");
        table.put("ExecutedBy", "Karthik");
        table.put("RequestedBy", "Jacob");
        table.put("BuildNo", "1.0");
        table.put("ApplicationVersion", "1.0");
        table.put("MachineName", "Windows 10");
        table.put("TestType",1);

        DataBaseUtil.ExecuteStoredProc("sp_CreateTestCycleID",table, connection );

    }
    //Method to insert details to the "sp_CreateTestCycleID" table created in SQL Server Management Studio
    public static void WriteTestResult(Connection connection,String featureName,String scenarioName,String stepName,String exception,String result)
    {
        try
        {
            Hashtable table = new Hashtable();
            table.put("FeatureName",featureName);
            table.put("ScenarioName",scenarioName);
            table.put("StepName",stepName);
            table.put("Exception",exception);
            table.put("Result",result);
            DataBaseUtil.ExecuteStoredProc("sp_insertResult",table,connection);
        }
        catch(Exception e)
        {
            e.getStackTrace();

        }


    }
    
   

}
