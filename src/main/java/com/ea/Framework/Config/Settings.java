package com.ea.Framework.Config;

import com.ea.Framework.Utilities.LogUtil;
import com.ea.Framework.base.BrowserType;
import gherkin.formatter.model.Feature;

import java.sql.Connection;

public class Settings
{
    //For Application Back End
    public static Connection AUTConnections;
    //For EARS Reporting
    public static Connection ReportingConnection;
    //For Application Backend Connection String
    public static String AUTConnectionString;
    public static String ReportingConnectionString;
    //Log Path for Framework
    public static String LogPath;
    //Driver Type for SQL Server connectivity
    public static String DriverType;
    public static String ExcelSheetPath;
    public static String AUT;
    public static String URL;
    public static LogUtil log;
    public static String FeatureContext;
    public static String ScenarioContext;
    public static String reportConfigPath;
}
