package com.aston.aName.View;

import java.util.Scanner;
import com.aston.aName.Util.CSVTool;

public class TUI {
	private Scanner reader;

	public TUI(Scanner reader) {
		this.reader  =reader;
	}

	/**
	 * Creates UI which receives input from user.
	 */
	public void textUserInterface(){
		System.out.println("Hello and welcome to MTR \n");
		commands();

		while(true) {
			int response = 0;
			//if user enters string, prompts user to enter a number.
			try{
				response = Integer.parseInt(reader.nextLine());
				if(response == 6) { //exits loop
					break;
				}
				loop(response);
			}
			catch(NumberFormatException e){
				System.out.println("Please enter a number corresponding to an option \n \t For example pressing 6 will quit \n");
			}
			commands();
		}
		System.out.println("Goodbye!");	
	}
	/**
	 * Functions available to user
	 */
	private void commands() {
		System.out.println("Following commands are available: ");
		System.out.println("[1] Find terminal in common");
		System.out.println("[2] Find path between two terminals");
		System.out.println("[3] Find all lines connected to specified line");
		System.out.println("[4] List all terminals");
		System.out.println("[5] Specify file path");
		System.out.println("[6] Quit");
		System.out.print("> ");//cursor (where user enters)
	}

	/**
	 * Receives decision from textUserInterface().
	 * Then carries out function.
	 * @param decision received from textUserInterface
	 */
	private void loop(int decision) {

		switch (decision) {

		case 1: System.out.println("first selected (Function null)");
		break;
		case 2: System.out.println("second selected (Function null)");
		break;
		case 3: System.out.println("third selected (Function null)");
		break;
		case 4: System.out.println("fourth selected (Function null)");	
		break;
		case 5: changeFilePath();
		break;	
		default: System.out.println("Invalid option \n");// if not options 1-6 user is told so
		break;
		}
	}

	/**
	 * Changes the file path, to whatever the suer enters
	 */
	private void changeFilePath(){
		System.out.println("The current file path is: " + CSVTool.getCurrentPath());	
		System.out.print("Specify new path: ");
		String path = reader.nextLine();//new path
		CSVTool.setFilePath(path);
		System.out.println("The file Path is now: " + CSVTool.getCurrentPath() + "\n");//shows new path
	}

}
