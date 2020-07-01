package com.ea.Framework.Utilities;
/*
 *  excel automation for Data Driven Testing
 *  Create any data driven method and utilize in the main @Test
 */

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {
    static Sheet wrksheet;
    static Workbook wrkbook = null;
    static Hashtable dict= new Hashtable();
    
    //Create a Constructor
    public  ExcelUtil(String ExcelSheetPath) throws BiffException, IOException
    {
        //Initialize
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet("Sheet1");
        //For Demo purpose the excel sheet path is hardcoded, but not recommended :)

        //mentain column dictionary
        ColumnDictionary();
    }

    //Returns the Number of Rows
    public static int RowCount()

    {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column,int row)
    {

        return wrksheet.getCell(column,row).getContents();
    }
    //Returns the cell value by taking row and column values as argument
    public static String ReadCell(String columnname,String testcaseid)
    {
    	int rowindex = 0;
    	 for(int i=0;i < wrksheet.getRows();i++)
    	 {
    		 if (wrksheet.getCell(0, i).getContents().equals(testcaseid))
    		 {
    		      rowindex =  wrksheet.getCell(0, i).getRow();
    			break;
    		 }
    		 else {
    			 if(wrksheet.getCell(0, i).getRow()== wrksheet.getRows()-1)
    			 {
    				 System.out.println("Test ID not present");
    			 }
    			 else
    			 {
    				 System.out.println("Continue searching");
    			 }
    		 }
    	   		 
    	 }
    	 return ReadCell(GetCell(columnname),rowindex); 
    		 
        
    }


    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary()
    {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for(int col=0;col < wrksheet.getColumns();col++)
        {
            dict.put(ReadCell(col,0), col);
        }
    }

    //Read Column Names
    private static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }
}
