package main;

import java.util.Scanner;

public class InputHandler {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static String takeStringInput() {
		return scan.nextLine();
	}
	
	
}
