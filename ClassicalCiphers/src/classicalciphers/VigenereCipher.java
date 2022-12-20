/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicalciphers;

/**
 * Class Name: Vigenere Cipher
 *
 * @author Melina Dimitrova
 * @version 1
 *
 * Class Description: This class is used to decode the Vigenère cipher, a
 * polyalphabetic substitution cipher where a message is encrypted using a
 * secret key, as well as an encryption table (Vigenère Square). Each row of the
 * square has the 26 letters of the Latin alphabet, shifted one position to the
 * right in a cyclic way as the rows progress downwards.
 */

public class VigenereCipher {

    // Key generation for Vigenere
    static String generateKey(String str, String key) {
        int x = str.length();

        for (int i = 0;; i++) {
            if (x == i) {
                i = 0;
            }
            if (key.length() == str.length()) {
                break;
            }
            key += (key.charAt(i));
        }
        return key;
    }

// Function to return the encrypted text
// generated with the help of the key
    static String cipherText(String str, String key) {
        String cipher_text = "";

        for (int i = 0; i < str.length(); i++) {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            // convert into ASCII
            x += 'A';

            cipher_text += (char) (x);
        }
        return cipher_text;
    }

// Function to decrypt the encrypted text
// and return the original text
    static String originalText(String cipher_text, String key) {
        String orig_text = "";

        for (int i = 0; i < cipher_text.length()
                && i < key.length(); i++) {
            // converting in range 0-25
            int x = (cipher_text.charAt(i)
                    - key.charAt(i) + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text += (char) (x);
        }
        return orig_text;
    }

}
