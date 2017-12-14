package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Line extends DoubleList<Station>
{
	// Holds a list of stations on this line
	private ArrayList<Station> stationsOnLine = new ArrayList<Station>();
	
	private HashMap<Line, Station> connectedLines = new HashMap<Line, Station>();	
	
	private String lineName;
	
	private static boolean first = true;
	
	public Line(String lineName, ArrayList<Station> stationsOnLine)
	{	
		super();
		this.lineName = lineName;
		this.stationsOnLine = stationsOnLine;
		
		for (int i = 0; i < stationsOnLine.size(); i++)
		{
			if (i == 0)
			{
				addLast(stationsOnLine.get(i));
			}
			else
			{
				addLast(stationsOnLine.get(i));
			}
			
			if (ApplicationStarter.DEBUG)
			{
				System.out.println("Added " + stationsOnLine.get(i).getName() + " to List");
			}
		}
		
		if(first)
		{
			System.out.println(toString());
			System.out.println(this.printStations());
			System.out.println(lineName + " | ArrayList size: " + stationsOnLine.size() + " | LinkedList Size: " + this.size());
			first = false;
		}
	}
	
	public String printStations()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(lineName + ": ");
		
		Iterator<Station> temp = iterator();
		while(temp.hasNext())
		{
			sb.append(temp.next().getName() + ", ");
		}
		
		return sb.toString();
	}
	
	// adds a new connected line
	public void addconnectedLine(Line connectingLine, Station connectingStation)
	{
		connectedLines.put(connectingLine, connectingStation);
	}
	
	public void registerLine()
	{
		for (Station s : stationsOnLine)
		{
			s.addConnectedLine(this);
		}
	}
	
	// operation will be total O(N^3)
	public void registerConnectedLines()
	{
		for (Station s : stationsOnLine)
		{
			if (!(s.getConnectedLines().size() <= 1) )
			{
				for (Line l : s.getConnectedLines())
				{
					if (!(l.equals(this)))
					{
						connectedLines.put(l, s);
					}
				}
			}
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
	
	// Will ensure the Station's name is used to check for equality. Can accept a line or String Object
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
	    else if (o instanceof String)
	    {
	    	String temp = (String) o;
	    	
	        if (this.lineName.equals(temp))
	        {
	            return true;
	        }
	    }
	    return false;
	}

}
