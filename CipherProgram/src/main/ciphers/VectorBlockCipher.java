package main.ciphers;

import java.util.ArrayList;
import main.tools.Manipulator;

public class VectorBlockCipher {
	
	/**<strong>blockSize</strong>
	 * <p>The block size in bytes. Default is 32</p>
	 */
	public static int blockSize = 32;
	
	/**<strong>VectorBlockCipher()</strong>
	 * <p>This will initialize the cipher with the default size of 32 bytes for a block.</p>
	 */
	public VectorBlockCipher() {
		blockSize = 32;
	}
	
	/**<strong>VectorBlockCipher()</strong>
	 * <p>This will let you set the size of the block.</p>
	 */
	public VectorBlockCipher(int blockSize) {
		VectorBlockCipher.blockSize = blockSize;
	}
	
	/**<strong>encrypt()</strong>
	 * <p>Will encrypt an input of n bytes long in block size.</p>
	 * @param input 'String'
	 * @param key 'String'
	 * @return encrypted text 'String'
	 */
	public static String encrypt(String input, String key) {
		int[] list = Manipulator.charArrayToNumbers(input.toCharArray());
		int[] keyList = Manipulator.charArrayToNumbers(key.toCharArray());
		ArrayList<Integer> arayListInt = new ArrayList<Integer>();
		int index = 0;
		
		for (int l : list) {
			if (index >= blockSize) {
				index = 0;
			}
			// Will flip the movement of the text through the keyspace based on index
			if ((index % 2) == 0) {
				arayListInt.add(Math.floorMod((l + keyList[index]), (Manipulator.MAXALPHASCII + 1)));
			} else {
				arayListInt.add(Math.floorMod((l - keyList[index]), (Manipulator.MAXALPHASCII + 1)));
			}
			index ++;
		}
		
		index = 0;
		int[] senderListInt = new int[arayListInt.size()];
		
		for (int i : arayListInt) {
			senderListInt[index] = i;
			index ++;
		}
		
		return Manipulator.charArrayToString(Manipulator.numbersToChar(senderListInt));
	}
	
	/**<strong>decrypt()</strong>
	 * <p>Will decrypt an input of n bytes long in block size.</p>
	 * @param input 'String' (should be previously encrypted text)
	 * @param key 'String' (should be the same key used to encrypt)
	 * @return encrypted text 'String'
	 */
	public static String decrypt(String input, String key) {
		int[] list = Manipulator.charArrayToNumbers(input.toCharArray());
		int[] keyList = Manipulator.charArrayToNumbers(key.toCharArray());
		ArrayList<Integer> arayListInt = new ArrayList<Integer>();
		int index = 0;
		
		for (int l : list) {
			if (index >= blockSize) {
				index = 0;
			}
			// Will flip the movement of the text through the keyspace based on index
			if ((index % 2) == 0) {
				arayListInt.add(Math.floorMod((l - keyList[index]), (Manipulator.MAXALPHASCII + 1)));
			} else {
				arayListInt.add(Math.floorMod((l + keyList[index]), (Manipulator.MAXALPHASCII + 1)));
			}
			index ++;
		}
		
		index = 0;
		int[] senderListInt = new int[arayListInt.size()];
		
		for (int i : arayListInt) {
			senderListInt[index] = i;
			index ++;
		}
		
		return Manipulator.charArrayToString(Manipulator.numbersToChar(senderListInt));
	}
}
