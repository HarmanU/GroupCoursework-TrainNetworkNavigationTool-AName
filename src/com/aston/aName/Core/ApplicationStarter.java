package com.aston.aName.Core;

import com.aston.aName.Util.CSVTool;

public class ApplicationStarter {

	public static void main(String[] args) {
		
		CSVTool.CSVToStringList();
		System.out.println(CSVTool.getCurrentPath());
		
		System.out.println("");
		
		for(String s : CSVTool.getLastReadFile())
		{
			System.out.println(s);
		}
	}

}
