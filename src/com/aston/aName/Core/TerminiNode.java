package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.Iterator;

public class TerminiNode {
	private DoubleNode<Station> stationNode;
	private DoubleList<Line> lines;//lines in list
	private DoubleNode<Station> reverseStation;//allows reverse traversal

	public TerminiNode(){
		lines = new LineList(CoreSystem.getLinesinSystem());
		addStationsToNode();
	}

	//adds stations to node
	private void addStation(Station s){
		DoubleNode<Station> node = new DoubleNode<Station>(s);//next node to add to link

		node.setNext(stationNode);//new nodes next is previous node (lastNode)

		if(stationNode == null){//reverseStation points to last node, allows reverse traversal
			reverseStation = node;
		}
		if(stationNode != null){
			stationNode.setPrevious(node);
		}

		stationNode = node;//lastNode points to newly added node/

	}

	//add stations to node
	private void addStationsToNode(){

		Iterator<Line> iter = lines.iterator();//itertor to iterate through lines to get stations
		while(iter.hasNext()){
			ArrayList<Station> stations = iter.next().getStationsOnLine();//holds stations on current line
			for(Station element: stations){
				addStation(element);//adds station to node
			}
		}
	}

	//goes through stations node
	public void fowardTraversal(){
		DoubleNode<Station> current = stationNode;
		while(current != null){
			System.out.println(current.getElement().getName());
			current = current.getNext();
		}
	}

	//goes through nodes in reverse
	public void reverseTraversal(){
		System.out.println("---------------Now backWards---------------");
		DoubleNode<Station> current = reverseStation;
		while(current != null){
			System.out.println(current.getElement().getName());
			current = current.getPrevious();
		}
	}
}
