/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicalciphers;

/**
 * Class Name: Atbash Cipher
 *
 * @author Melina Dimitrova
 * @version 1
 *
 * Class Description: This class is used to decode the Atbash Cipher, a
 * monoalphabetic substitution cipher formed by taking the alphabet and mapping
 * it to its reverse, so that the first letter becomes the last letter, e.g. A
 * becomes Z, B becomes Y etc.
 */

public class AtbashCipher {

    // Encryption method    
    public String encrypt(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int newChar = ('A' - c) + 'Z';
                encoded.append((char) newChar);
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    // Decryption method    
    public String decrypt(String message) {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int newChar = ('Z' - c) + 'A';
                decoded.append((char) newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
