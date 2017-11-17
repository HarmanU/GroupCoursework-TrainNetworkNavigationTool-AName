package com.aston.aName.Core;

import java.util.Scanner;

import com.aston.aName.Util.CSVTool;
import com.aston.aName.View.TUI;

public class ApplicationStarter {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		CSVTool.CSVToStringList();
		TUI tui = new TUI(scan);
		tui.textUserInterface();

	}

}
