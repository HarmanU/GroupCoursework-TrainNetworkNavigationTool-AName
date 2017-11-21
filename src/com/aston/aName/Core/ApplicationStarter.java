package com.aston.aName.Core;

import java.util.Date;
import java.util.Scanner;

import com.aston.aName.Util.CSVTool;
import com.aston.aName.View.TUI;

public class ApplicationStarter {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static boolean DEBUG = true;
	
	public static void main(String[] args) {
		
		try 
		{
			int i = Integer.parseInt(args[0]);
			System.out.println("" + i);
			
		}
		catch (NumberFormatException e)
		{
			System.out.println("YOU DONUT NOSE LONG LIKE GARDEN HOSE\n\n");
		}
		
		if (args != null)
		{
			DEBUG = Boolean.parseBoolean(args[0]);
		}
		
		// Start Timer
		long startTime = new Date().getTime();
		
		//System Start up
		CoreSystem.generateMap(CSVTool.CSVToStringList(), DEBUG);
		TUI tui = new TUI(scan);
		
		// End Timer
		long endTime = new Date().getTime();
		
		System.out.println("Total Initialisation time: " + (endTime - startTime) + "ms");
		System.out.println("");
		
		tui.textUserInterface();
	}

}
