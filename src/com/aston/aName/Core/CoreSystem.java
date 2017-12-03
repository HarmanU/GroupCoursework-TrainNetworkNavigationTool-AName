package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.aston.aName.Util.Controller;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class CoreSystem implements Controller{
	
	private static CoreSystem instance;
	
	private static ArrayList<Line> linesInSystem = new ArrayList<Line>();	
	private static ArrayList<Station> stationsInSystem = new ArrayList<Station>();
	
	private static boolean DEBUG;
	
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
	
	public static void setDebugState(boolean newDebugState)
	{
		DEBUG = newDebugState;
	}
	
	//-----------------------------------------------------|-----------------------|-----------------------------------------------------
	
	public static void generateMap(ArrayList<String> CSVData)
	{
		StringBuilder log = new StringBuilder();
		
		log.append("List Loaded into System of size: " + CSVData.size());
		
		createObjects(CSVData);
		
		createLinks(CSVData);
		
		// To Print Debug information if debug is set to true
		if (DEBUG)
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
			l.registerLine();
		}
		
		for (Line l : linesInSystem)
		{
			l.registerConnectedLines();
		}
	}
	
	public static void Termini(){
		TerminiNode t = new TerminiNode();
		
	}

	@Override
	public String listAllTermini() {
		
		
		
		return null;
	}

	/*
	 * Method will list all stations on a line
	 * 'Should be O(N)'
	 */
	@Override
	public String listStationsInLine(String line) {
		
		StringBuilder sb = new StringBuilder();
		Line desiredLine = null;
		
		// Search for Line in System
		for (Line l : linesInSystem)
		{
			if (l.equals(line))
			{	
				if (DEBUG)
				{
					sb.append("\nCurrent Line Name: " + l.getLineName());
					sb.append("\nSearch Term: " + line);
				}
				desiredLine = l;
				break;
			}
		}
		
		sb.append("\n--------------------------- Current Query ---------------------------");
		
		if (desiredLine != null)
		{
			// Append desiredLine toString
			sb.append(desiredLine.toString());
		}
		else if (desiredLine == null)
		{
			// Append an error message if a line was not found
			sb.append(printLineNotFound());
		}
		
		// DEBUG CALL
		if (DEBUG && desiredLine != null)
		{
			sb.append("\nLine Index called:" + linesInSystem.indexOf(desiredLine));
		}

		sb.append("\n---------------------------------------------------------------------");
		return sb.toString();
	}

	/*
	 * Method to list all connected lines on a line and at what station
	 * 'Should be O(N)'
	 */
	@Override
	public String listAllDirectlyConnectedLines(String line) 
	{
		StringBuilder sb = new StringBuilder();
		Line desiredLine = null;
		
		// Search for Line in System
				for (Line l : linesInSystem)
				{
					if (l.equals(line))
					{	
						if (DEBUG)
						{
							sb.append("\nCurrent Line Name: " + l.getLineName());
							sb.append("\nSearch Term: " + line);
						}
						
						desiredLine = l;
						break;
					}
				}
				
				if (DEBUG && desiredLine != null)
				{
					sb.append("\nLine Index called:" + linesInSystem.indexOf(desiredLine));
				}
				
				if(desiredLine != null && desiredLine.getConnectedLines().isEmpty() == false)
				{
					HashMap<Line, Station> connectedLines = desiredLine.getConnectedLines();
					sb.append("\n--------------------------- Current Query ---------------------------");
					sb.append("\nLines connected to this one include:");
					
					for (Map.Entry<Line, Station> entry : connectedLines.entrySet())
					{
					    sb.append("\nThe " + entry.getKey().getLineName());
					}
				}
				else if (desiredLine != null && desiredLine.getConnectedLines().isEmpty() == true)
				{
					sb.append("\nNo Lines connect to " + desiredLine.getLineName());
				}
				else if (desiredLine == null)
				{
					printLineNotFound();
				}
				
		sb.append("\n---------------------------------------------------------------------");
		return sb.toString();
	}

	@Override
	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * A method for printing an error message if a line was not found in a query
	 * @return will return a String with error message
	 */
	public String printLineNotFound()
	{
		StringBuilder sb = new StringBuilder();
		
		// If no line was found then print message and list of current valid lines
		sb.append("\nLine of that name not found, ensure you typed the line name correctly including correct case");
		sb.append("\n\nCurrent lines include");
		for (Line l : linesInSystem)
		{
			sb.append("\n" + l.getLineName());
		}	
		return sb.toString(); 
	}

	//--------------------------------------------------------- Getter Methods --------------------------------------------------------

	public static ArrayList<Line> getLinesinSystem()
	{
		return linesInSystem;
	}
	
	public static ArrayList<Station> getStationinSystem()
	{
		return stationsInSystem;
	}
		
	//-----------------------------------------------------|-----------------------|-----------------------------------------------------
	
}
