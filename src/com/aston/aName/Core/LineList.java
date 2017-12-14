package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.Iterator;

public class LineList extends DoubleList<Line>{
	
	private ArrayList<Line> lines;

	public LineList(ArrayList<Line> lines){
		this.lines = lines;		
		goThroughLines();
	}

	//adds lines to DoubleList
	private void goThroughLines(){
		for(int x = 0; x < lines.size(); x++){
			addFirst(lines.get(x));
		}
	}
	
	//lists lines in DoubleList
	public void printLines(){
		Iterator<Line> temp = iterator();
		while(temp.hasNext()){
			System.out.println(temp.next().getLineName());
		}
	}
}
