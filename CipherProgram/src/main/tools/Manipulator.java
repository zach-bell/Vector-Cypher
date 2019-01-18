package main.tools;

/** <strong>Manipulator</strong>
 * <p>This class will manipulate many different forms of operations and will serve as
 * the main tool class for most of the ciphers.</p>
 * @author Zachary Vanscoit
 */
public class Manipulator {
	
	public static int MAXALPH = 128;
	
	public static void setMaxAlph(int n) {
		MAXALPH = n;
	}
	
	public static int shift(int n, int k) {
		return ((n + k) % MAXALPH);
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
	
	public static int[] shiftNumbersNoSpace(int[] input, int amount) {
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