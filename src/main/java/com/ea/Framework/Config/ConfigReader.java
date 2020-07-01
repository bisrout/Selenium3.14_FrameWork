package com.ea.Framework.Config;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader
{
    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }
    private void ReadProperty() throws IOException {

        Properties p= new Properties();
        InputStream inputStream = new FileInputStream("src\\main\\java\\com\\ea\\Framework\\Config\\GlobalConfig.properties");
        p.load(inputStream);
        Settings.AUTConnectionString=p.getProperty("AUTConnectionString");
        Settings.ReportingConnectionString=p.getProperty("ReportingConnectionString");
        Settings.LogPath=p.getProperty("LogPath");
        Settings.DriverType=p.getProperty("DriverType");
        Settings.ExcelSheetPath=p.getProperty("ExcelSheetPath");
        Settings.URL = p.getProperty("url");
        Settings.reportConfigPath=p.getProperty("reportConfigPath");





    }
}
