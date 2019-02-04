package main.tools;

/** <strong>Manipulator</strong>
 * <p>This class will manipulate many different forms of operations and will serve as
 * the main tool class for most of the ciphers.</p>
 * @author Zachary Vanscoit
 */
public class Manipulator {
	
	public static final int MAXALPHASCII = 128;
	
	public static final char[] alphabetTable = new char[] {
											'a','b','c','d','e','f','g','h','i','j','k','l','m',
											'n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static int shift(int n, int k) {
		return ((n + k) % MAXALPHASCII);
	}
	
	public static String shiftStringAlpha(String input, int amount) {
		String sender = "";
		char[] characters = input.toLowerCase().toCharArray();
		for (char c : characters) {
			for (int i = 0; i < alphabetTable.length; i++) {
				if (c == alphabetTable[i]) {
					CP.println("" + (Math.floorMod((i + amount), (alphabetTable.length))));
					sender += alphabetTable[(Math.floorMod((i + amount), (alphabetTable.length)))];
					break;
				}
			}
		}
		return sender;
	}
	
	public static char[] stringToCharArray(String input) {
		return input.toCharArray();
	}
	
	public static int[] charArrayToNumbers(char[] input) {
		int[] sender = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			sender[i] = input[i];
		}
		return sender;
	}
	
	public static int[] shiftNumbers(int[] input, int amount) {
		int[] sender = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			sender[i] = shift(input[i], amount);
		}
		return sender;
	}
	
	public static int[] shiftNumbersWithSpace(int[] input, int amount) {
		int[] sender = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i] != 32) {
				sender[i] = shift(input[i], amount);
			} else {
				sender[i] = input[i];
			}
		}
		return sender;
	}
	
	public static char[] numbersToChar(int[] input) {
		char[] sender = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 0 | input[i] <= 127)
				sender[i] = (char) input[i];
		}
		return sender;
	}

}
