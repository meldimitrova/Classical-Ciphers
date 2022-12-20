/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicalciphers;

/**
 * Class Name:    Caesar Cipher
 * @author Melina Dimitrova
 * @version 1
 * 
 * Class Description: This class is used to decode the Ceaser Cipher, a
 * monoalphabetic substitution cipher where each letter in the plaintext is
 * shifted according to the integer between 0-25 denotating the shift.
 */

public class CaesarCipher {

    // Define shift    
    private byte shift = 1;

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public byte getShift() {
        return shift;
    }

    public CaesarCipher setShift(byte shift) {
        this.shift = shift;
        return this;
    }

    // Encryption method    
    public String encrypt(String plaintext) {
        byte shift = this.getShift();
        StringBuilder ciphertext = new StringBuilder();

        for (char chr : plaintext.toLowerCase().toCharArray()) {
            byte position = (byte) alphabet.indexOf(chr);
            if (chr == ' ') {
                ciphertext.append(" ");
            } else {
                ciphertext.append(alphabet.charAt((position + shift) % 26));
            }
        }

        return ciphertext.toString();
    }

    // Decryption method     
    public String decrypt(String chipertext) {
        byte shift = this.getShift();
        StringBuilder ciphertext = new StringBuilder();

        for (char chr : chipertext.toLowerCase().toCharArray()) {
            byte position = (byte) alphabet.indexOf(chr);
            if (chr == ' ') {
                ciphertext.append(" ");
            } else {
                ciphertext.append(alphabet.charAt((position - shift) < 0 ? ((position - shift) % 26 + 26) % 26 : (position - shift) % 26));
            }
        }

        return ciphertext.toString();
    }
}
