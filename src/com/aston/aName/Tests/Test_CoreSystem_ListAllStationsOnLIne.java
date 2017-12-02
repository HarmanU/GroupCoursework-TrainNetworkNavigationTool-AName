package com.aston.aName.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.aston.aName.Core.CoreSystem;
import com.aston.aName.Core.Line;
import com.aston.aName.Util.CSVTool;

public class Test_CoreSystem_ListAllStationsOnLIne {
	
	ArrayList<Line> linesInSystem;
	

	@Before
	public void setUp() throws Exception {
		
		CoreSystem.setDebugState(false);
		CoreSystem.generateMap(CSVTool.CSVToStringList());
		
		linesInSystem = CoreSystem.getInstance().getLinesinSystem();
	}
	
	@Test
	public void testListAllConnectedLines_Option3() {
		
		String testData = "\n\nAirport Express: AsiaWorld-Expo, Airport, Tsing Yi, Kowloon, Hong Kong, ";
		
		System.out.print("Line at index 0 :" + linesInSystem.get(0).getLineName() + ":");
		
		assertEquals(testData, CoreSystem.getInstance().listAllDirectlyConnectedLines("Airport Express"));
	}

	@Test
	public void testListStationsInLine_Option2() {
		
		String testData = "\n\nAirport Express: AsiaWorld-Expo, Airport, Tsing Yi, Kowloon, Hong Kong, ";
		
		System.out.print("Line at index 0 :" + linesInSystem.get(0).getLineName() + ":");
		
		assertEquals(testData, CoreSystem.getInstance().listStationsInLine("Airport Express"));
	}

}
