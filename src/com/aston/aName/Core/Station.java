package com.aston.aName.Core;

import java.util.ArrayList;

public class Station {
	
	private String stationName;
	
	private ArrayList<Line> connectedLines = new ArrayList<Line>();
	
	public Station(String stationName)
	{
		this.stationName = stationName;
	}
//-------------------------------------------------------- SETTER METHODS --------------------------------------------------------
	
	public void addConnectedLine(Line line)
	{
		connectedLines.add(line);
	}

//-------------------------------------------------------- GETTER METHODS --------------------------------------------------------
	
	public String getName()
	{
		return stationName;
	}
	
	public ArrayList<Line> getConnectedLines()
	{
		return connectedLines;
	}

//-------------------------------------------------------- OVERIDDEN METHODS --------------------------------------------------------
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n" + stationName + ": ");
		
		for (Line l : connectedLines)
		{
			sb.append(l.getLineName() + ", ");
		}
		
		return sb.toString();
	}
	
	// Will ensure the Station's name is used to check for equality
	public boolean equals(Object o)
	{
	    if (o instanceof Station)
	    {
	        Station temp = (Station) o;
	        
	        if (this.stationName.equals(temp.getName()))
	        {
	            return true;
	        }
	    }
	    return false;
	}

}
