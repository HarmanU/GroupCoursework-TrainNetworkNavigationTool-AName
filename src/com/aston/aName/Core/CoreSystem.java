package com.aston.aName.Core;

import java.util.ArrayList;

public class CoreSystem {
	
	private static CoreSystem instance;
	
	private static ArrayList<Line> linesInSystem = new ArrayList<Line>();	
	private static ArrayList<Station> stationsInSystem = new ArrayList<Station>();
	
	//----------------------------------------------------- Ensures single Instance -----------------------------------------------------
	private CoreSystem()
	{
		
	}
	
	static
	{
		instance = new CoreSystem();
	}
	
	public static CoreSystem getInstance()
	{
		return instance;
	}
	
	//-----------------------------------------------------|-----------------------|-----------------------------------------------------
	
	public static void generateMap(ArrayList<String> CSVData, boolean debug)
	{
		StringBuilder log = new StringBuilder();
		
		log.append("List Loaded into System of size: " + CSVData.size());
		
		createObjects(CSVData);
		
		createLinks(CSVData);
		
		// To Print Debug information if debug is set to true
		if (debug)
		{
			log.append("\n\nTotal of " + linesInSystem.size() + " Lines added");
			log.append("\nTotal of " + stationsInSystem.size() + " Stations added");
			log.append("\n------------------------------------------------------------");
			
			for (Line l : linesInSystem)
			{
				log.append(l.toString());
			}
			
			log.append("\n------------------------------------------------------------");
			
			for (Station s : stationsInSystem)
			{
				log.append(s.toString());
			}
			
			log.append("\n------------------------------------------------------------");
		}
		
		System.out.println(log.toString());
	}
	
	private static void createObjects(ArrayList<String> CSVData)
	{
		// read CSV Data
		for (String s : CSVData)
		{
			// Split Line
			String[] processedLine = s.split(",");
			
			// Stations to be added to line
			ArrayList<Station> stationsToBeAddedToLine = new ArrayList<Station>();
			
			for (int i = 1; i < processedLine.length; i++)
			{
				// Make a station with name i...
				Station stationToBeAdded = new Station(processedLine[i]);
				
				// If that station doesn't exist then create it...
				if (!stationsInSystem.contains(stationToBeAdded))
				{
					stationsInSystem.add(stationToBeAdded);
					stationsToBeAddedToLine.add(stationToBeAdded);
				}
				else if (stationsInSystem.contains(stationToBeAdded))
				{
					stationsToBeAddedToLine.add(stationsInSystem.get(stationsInSystem.indexOf(stationToBeAdded)));
				}				
			}
			
			// Add the new line to system records
			linesInSystem.add(new Line(processedLine[0], stationsToBeAddedToLine));
		}
	}

	private static void createLinks(ArrayList<String> CSVData)
	{
		for (Line l : linesInSystem)
		{
			l.refreshLines();
		}
	}
	
	public static void Termini(){
		TerminiNode t = new TerminiNode(linesInSystem);
	}


	
}
