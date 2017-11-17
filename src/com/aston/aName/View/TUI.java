package com.aston.aName.View;

import java.util.Scanner;
import com.aston.aName.Util.CSVTool;

public class TUI {
	private Scanner reader;
	
	
	public TUI(Scanner reader) {
		this.reader  =reader;
	}
	
	//ability to change path for file
	
	public void textUserInterface(){
		boolean run = true;
		System.out.println("Hello and welcome to MTR \n");
		commands();
		int response = Integer.parseInt(reader.nextLine());
		
		while(run) {
		
		switch (response) {
		
		case 1: System.out.println("first selected");
				run = false;
				break;
		case 2: System.out.println("second selected");
				run = false;
				break;
		case 3: System.out.println("third selected");
				run = false;
				break;
		case 4: System.out.println("fourth selected");	
				run = false;
				break;
		case 5: System.out.println("Your current path is: " + CSVTool.getCurrentPath());	
				System.out.println("Specify new path: ");
				String path = reader.nextLine();
				CSVTool.setFilePath(path);	
				run = false;
				break;
		case 6: run = false;
				break;		
		default: System.out.println("Invalid option");
				commands();
				run = false;
				break;
		}
	}
		
	 System.out.println("Goodbye!");	
	}
	
	public void commands() {
		System.out.println("Following commands are available: ");
		System.out.println("[1] Find terminal in common");
		System.out.println("[2] Find path between two terminals");
		System.out.println("[3] Find all lines connected to specified line");
		System.out.println("[4] List all terminals");
		System.out.println("[5] Specify file path");
		System.out.println("[6] Quit");
	}
	
}
