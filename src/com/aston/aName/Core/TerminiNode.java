package com.aston.aName.Core;

import java.util.ArrayList;

public class TerminiNode {
	private DoubleNode<Station> StationsOnLine;
	//private DoubleNode<Station> prev;
	private DoubleNode<Line> linesNode;
	private ArrayList<Line> lines;

	public TerminiNode(ArrayList<Line> lines){
		this.lines = lines;
		goThroughLines();
		addStationsToNode();
		goThroughNode(StationsOnLine);
	}
	//need to create links to stations
	
	// need to add previous node
	private void addLineToNode(Line line){

		DoubleNode<Line> node = new DoubleNode<Line>(line);//next node to add to link

		node.setNext(linesNode);//new nodes next is previous node (lastNode)

		linesNode = node;//lastNode points to newly added node/
	}

	//adds stations to node
	private void addStation(Station s){

		DoubleNode<Station> node = new DoubleNode<Station>(s);//next node to add to link

		node.setNext(StationsOnLine);//new nodes next is previous node (lastNode)
		//node.setPrevious(linesNode);
		StationsOnLine = node;//lastNode points to newly added node/
	}

	//adds lines to nodes
	public void goThroughLines(){
		for(Line element : lines){
			this.addLineToNode(element);
		}
	}

	private void addStationsToNode(){
		DoubleNode<Line> current = linesNode;
		ArrayList<Station> stationsOnLine = current.getElement().getStationsOnLine();//holds stations on selected line

		while(current != null){
			for(Station s : stationsOnLine){
				addStation(s);
			}
			stationsOnLine = current.getElement().getStationsOnLine();

			current = current.getNext();
		}
	}

	//goes through stations node
	private void goThroughNode(DoubleNode<Station> node){
		DoubleNode<Station> current = node;
		while(current != null){
			System.out.println(current.getElement().getName());
			current = current.getNext();
		}
	}
}
