package main;

import main.ciphers.CaesarCypher;

public class CipherLauncher {

	public static void main(String[] args) {
		int key = 3;
		
		String decrypted = CaesarCypher.decrypt(InputHandler.takeStringInput(), key);
		System.out.println("Decrypted Message: " + decrypted);
		System.out.println("\nEnd.");
	}

}
