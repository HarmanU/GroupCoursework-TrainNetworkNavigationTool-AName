package com.aston.aName.Core;

import java.util.ArrayList;
import java.util.Iterator;

public class TerminiNode {
	private DoubleNode<Station> StationsOnLine;
	private DoubleList<Line> lines;
	private ArrayList<DoubleNode<Station>> container;

	public TerminiNode(){
		container = new ArrayList<>();
		lines = new LineList();
		addStationsToNode();
		goThroughNode();
	}

	//adds stations to node
	private void addStation(Station s){


		DoubleNode<Station> node = new DoubleNode<Station>(s);//next node to add to link

		node.setNext(StationsOnLine);//new nodes next is previous node (lastNode)
		if(StationsOnLine != null){
			StationsOnLine.setPrevious(node);
		}

		StationsOnLine = node;//lastNode points to newly added node/

	}


	//needs fixing
	private void addStationsToNode(){
		Iterator<Line> temp = lines.iterator();
		ArrayList<Station> stations = null;
		DoubleNode<Station> nodeToAdd = null;

		while(temp.hasNext()){
			stations = temp.next().getStationsOnLine();
			for(Station element : stations){
				DoubleNode<Station> node = new DoubleNode<Station>(element);
				nodeToAdd = node;
				
				node.setNext(nodeToAdd);//new nodes next is previous node (lastNode)
				if(nodeToAdd != null){
					nodeToAdd.setPrevious(node);
				}

				nodeToAdd = node;//lastNode points to newly added node/
			}
			container.add(nodeToAdd);
		}
	}

	//needs fixing
	//goes through stations node
	private void goThroughNode(){
		/*DoubleNode<Station> current = node;
		while(current != null){
			System.out.println(current.getElement().getName());
			current = current.getNext();
		}*/
		
	}


}
