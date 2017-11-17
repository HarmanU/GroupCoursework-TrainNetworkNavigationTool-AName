package com.aston.aName.Util.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.aston.aName.Util.CSVTool;

public class Test_CSVTool {
	
	private ArrayList<String> testList = new ArrayList<String>();
	
	private ArrayList<String> loadedList;

	@Before
	public void setUp() throws Exception {
		
		CSVTool.setFilePath("./test/testfile.csv");
		
		testList.add("testdata1,testdate2,testdata3");
		testList.add("1,2,3");
		testList.add("1.1,2.2,3.3");
		
	}

	@Test
	public void testPath() {
		
		assertEquals("./test/testfile.csv", CSVTool.getCurrentPath());	
	}
	
	@Test
	public void testLoad()
	{
		loadedList = CSVTool.CSVToStringList();
		
		for(int i = 0; i < loadedList.size(); i++)
		{
			assertEquals(testList.get(i), loadedList.get(i));
		}
	}
	
	@Test
	public void testLoadedList()
	{
			assertEquals(loadedList, CSVTool.getLastReadFile());
	}

}
