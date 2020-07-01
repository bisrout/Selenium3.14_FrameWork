package com.ea.Framework.Utilities;
/*
 * Extended for Cucumber Implementation with Data provider
 */



import cucumber.api.DataTable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CucumberUtil {
    String val=null;




    private static List<DataCollection>  _datacollection = new ArrayList<>();

    public static List<DataCollection> ConvertDatatableToDict(DataTable table)
    {
        List<List<String>> data = table.raw();
        int rowNumber=0;
        for (List<String> col : data)
        {
            for (int colIndex=0;colIndex<col.size();colIndex++)
            {
                _datacollection.add(rowNumber,new DataCollection(data.get(0).get(colIndex),col.get(colIndex),rowNumber));
            }
            rowNumber++;
        }
        return _datacollection;

    }

    /*public static String GetCellValue(String columnName)
    {

        return _datacollection.get(columnName).ColoumnValue;
    }*/
    public static String  GetCellValueWithRowIndex(String columnName,int rowNumber)
    {
        final String[] columnValue = {null};
        _datacollection.forEach(x->{
            if (x.ColoumnName.equals(columnName) && x.RowNumber ==rowNumber){
                columnValue[0]=x.ColoumnValue;
            }
        });
        return columnValue[0];
    }

    public static class DataCollection
    {
        private String ColoumnName;
        private String ColoumnValue;
        private int RowNumber;

        public DataCollection(String columnName,String columnValue,int rowNumber)
        {
            ColoumnName=columnName;
            ColoumnValue=columnValue;
            RowNumber=rowNumber;
        }
    }

    //Read data from FeatureList.xls

    public static ArrayList<String> getFeaturetoRun(String ExcelSheetPath) throws IOException, BiffException {
        Sheet wrksheet;
        Workbook wrkbook = null;
        ArrayList <String> dict = new ArrayList<String>();
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet("Sheet1");
        int rowcount = wrksheet.getRows();
        String val = wrksheet.getCell(1,1).getContents();
        for(int i=1;i<rowcount;i++)
        {

            if (wrksheet.getCell(1,i).getContents().equals("N"))
            {
                dict.add(wrksheet.getCell(0,i).getContents());

            }
            else
            {
                dict.add("No Scenario in N Status");

            }
        }
        return dict;

    }




}
