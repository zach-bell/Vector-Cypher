package main.ciphers;

import main.tools.Manipulator;

public class CaesarCypher {
	
	/**<Strong>encrypt()</strong>
	 * <p>This method can be used to encrypt a string input by using a standard integer key.
	 * The encryption uses the manipulator class to convert the string to characters, convert
	 * the characters to integers on the standard ASCII table, shift those integers up n times
	 * (represented as the "int key," then convert the new shifted array to characters, and
	 * finally return a string.</p>
	 * @param "input" standard String input to encrypt.
	 * @param key number of times to shift the text.
	 * @return A string that has been encrypted by shifting with the int key.
	 */
	public static String encrypt(String input, int key) {
		String sender = "";
		for (char c : Manipulator.numbersToChar(Manipulator.shiftNumbersNoSpace(
				Manipulator.charArrayToNumbers(Manipulator.stringToCharArray(input)),key))) {
			sender += c;
		}
		return sender;
	}
	
	/**<Strong>decrypt()</strong>
	 * <p>This method can be used to decrypt a string input by using a standard integer key.
	 * The encryption uses the manipulator class to convert the string to characters, convert
	 * the characters to integers on the standard ASCII table, shift those integers up n times
	 * (represented as the "int key," then convert the new shifted array to characters, and
	 * finally return a string.</p>
	 * @param "input" standard String input to decrypt.
	 * @param key number of times to shift the text.
	 * @return A string that has been decrypt by shifting with the int key.
	 */
	public static String decrypt(String input, int key) {
		String sender = "";
		for (char c : Manipulator.numbersToChar(Manipulator.shiftNumbersNoSpace(
				Manipulator.charArrayToNumbers(Manipulator.stringToCharArray(input)),-key))) {
			sender += c;
		}
		return sender;
	}

}
