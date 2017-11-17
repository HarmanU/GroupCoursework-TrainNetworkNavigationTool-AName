package com.aston.aName.Util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVTool {
	
	private static String csvFilePath = "./MTRsystem_partial.csv"; // Default will look for file in root
	private static BufferedReader br = null;
	private static ArrayList<String> lastFileReadStorage;
	
	public static ArrayList<String> CSVToStringList()
	{

		String line = "";
		ArrayList<String> lineStorage = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFilePath));
            while ((line = br.readLine()) != null) {
            
            lineStorage.add(line);
            }

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            System.out.println("No file was found at that location. File path should look similar to this ( ./file.csv)");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println("Load Successful");
        
        lastFileReadStorage = lineStorage;
        
        return lineStorage;
		
	}
	
	public static String getCurrentPath()
	{
		return csvFilePath;
	}
	
	public static void setFilePath(String newPath)
	{
		csvFilePath = newPath;
	}
	
	public static ArrayList<String> getLastReadFile()
	{
		return lastFileReadStorage;
	}
	
        
}
