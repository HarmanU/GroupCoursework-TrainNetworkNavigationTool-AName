package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.HashMap;

public class Line 
{
	private ArrayList<Station> stationsOnLine = new ArrayList<Station>();
	
	private HashMap<Line, Station> connectedLines = new HashMap<Line, Station>();
	
	
	
	private String lineName;
	
	public Line(String lineName, ArrayList<Station> stationsOnLine)
	{		
		this.lineName = lineName;
		this.stationsOnLine = stationsOnLine;
	}
	
	// adds a new connected line
	public void addconnectedLine(Line connectingLine, Station connectingStation)
	{
		connectedLines.put(connectingLine, connectingStation);
	}
	
	public void refreshLines()
	{
		for (Station s : stationsOnLine)
		{
			s.addConnectedLine(this);
		}
	}
	
//-------------------------------------------------------- GETTER METHODS --------------------------------------------------------
	
	// Returns all lines connected to this line and at what station
	public HashMap<Line, Station> getConnectedLines()
	{
		return connectedLines;
	}
	
	// Returns line's name
	public String getLineName()
	{
		return lineName;
	}
	
	// Returns Stations on this line
	public ArrayList<Station> getStationsOnLine()
	{
		return stationsOnLine;
	}
	
//-------------------------------------------------------- OVERIDDEN METHODS --------------------------------------------------------
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n" + lineName + ": ");
		
		for (Station s : stationsOnLine)
		{
			sb.append(s.getName() + ", ");
		}
		
		return sb.toString();
	}
	
	// Will ensure the Station's name is used to check for equality
	public boolean equals(Object o)
	{
	    if (o instanceof Line)
	    {
	        Line temp = (Line) o;
	        
	        if (this.lineName.equals(temp.getLineName()))
	        {
	            return true;
	        }
	    }
	    return false;
	}

}
