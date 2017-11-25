package com.aston.aName.Core;

import java.util.Date;
import java.util.Scanner;

import com.aston.aName.Util.CSVTool;
import com.aston.aName.View.TUI2;
import com.aston.aName.View.TUIController;

public class ApplicationStarter {
	
	public static boolean DEBUG = true;
	
	public static void main(String[] args) {
		
		if (args != null)
		{
			DEBUG = Boolean.parseBoolean(args[0]);
		}
		
		// Start Timer
		long startTime = new Date().getTime();
		
		//System Start up
		CoreSystem.generateMap(CSVTool.CSVToStringList(), DEBUG);

		
		// End Timer
		long endTime = new Date().getTime();
		
		System.out.println("Total Initialisation time: " + (endTime - startTime) + "ms");
		System.out.println("");
	}

}
