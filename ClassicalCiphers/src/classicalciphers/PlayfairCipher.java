/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicalciphers;

import java.util.*;

/**
 * Class Name:    Playfair Cipher
 * @author Melina Dimitrova
 * @version 1
 * 
 * Class Description: This class is used to decode the Playfair Cipher, a
 * digram substitution cipher which encrypts pairs of letters
 * and uses a 5 by 5 table containing a keyword or phrase.
 */

public class PlayfairCipher {

    private static final String alphabet = "abcdefghiklmnopqrstuvwxyz";

    // Matrix for key    
    public String generateMatrix(String key) {

        String matrixstring = key + alphabet;
        StringBuilder mat = new StringBuilder();
        Set set = new LinkedHashSet();

        for (char chr : matrixstring.toLowerCase().toCharArray()) {
            set.add(chr);
        }
        set.forEach(chr -> {
            mat.append(chr);
        });

        return mat.toString();
    }

    // Method to divide the plaintext in pairs    
    public String[] divideToPairs(String message) {

        message = formatMessage(message);
        String pairs[] = new String[message.length() / 2];
        int j = 0;

        for (int i = 0; i < message.length(); i = i + 2) {
            pairs[j] = message.substring(i, i + 2);
            j++;
        }

        return pairs;
    }

    public String formatMessage(String message) {

        message = message.toLowerCase().replace(" ", "");
        StringBuilder mes = new StringBuilder(message);

        for (int i = 0; i < message.length() - 1; i += 2) {
            if (mes.charAt(i) == mes.charAt(i + 1)) {
                mes.insert(i + 1, "x");
            }
        }
        if (mes.length() % 2 == 1) {
            mes.append("x");
        }

        return mes.toString();
    }

    // Encryption method
    public String encrypt(String[] pairs, String matrix) {

        StringBuilder ciphertext = new StringBuilder();

        for (String pair : pairs) {//uses zero index
            byte row1 = (byte) (matrix.indexOf(pair.charAt(0)) / 5);
            byte col1 = (byte) (matrix.indexOf(pair.charAt(0)) % 5);
            byte row2 = (byte) (matrix.indexOf(pair.charAt(1)) / 5);
            byte col2 = (byte) (matrix.indexOf(pair.charAt(1)) % 5);

            char chr1;
            char chr2;
            if (col1 == col2) {
                chr2 = matrix.charAt(((row2 + 1) % 5 * 5 + col2));
                chr1 = matrix.charAt(((row1 + 1) % 5 * 5 + col1));
            } else if (row1 == row2) {
                chr1 = matrix.charAt(row1 * 5 + ((col1 + 1) % 5));
                chr2 = matrix.charAt(row2 * 5 + ((col2 + 1) % 5));
            } else {
                chr1 = matrix.charAt(row1 * 5 + col2);
                chr2 = matrix.charAt(row2 * 5 + col1);
            }
            ciphertext.append(Character.toString(chr1)).append(Character.toString(chr2));
        }

        return ciphertext.toString();
    }
    
    // Decryption method 
     public String decrypt(String[] pairs, String matrix) {

        StringBuilder ciphertext = new StringBuilder();

        for (String pair : pairs) {//using zero index
            byte row1 = (byte) (matrix.indexOf(pair.charAt(0)) / 5);
            byte col1 = (byte) (matrix.indexOf(pair.charAt(0)) % 5);
            byte row2 = (byte) (matrix.indexOf(pair.charAt(1)) / 5);
            byte col2 = (byte) (matrix.indexOf(pair.charAt(1)) % 5);
            //System.out.println("char 1 " + pair.charAt(0) + "  at " + row1 + "   " + col1);
            //System.out.println("char 2 " + pair.charAt(1) + "  at " + row2 + "   " + col2);

            char chr1;
            char chr2;
            if (col1 == col2) {
                chr2 = matrix.charAt(((row2 - 1) % 5 * 5 + col2));
                chr1 = matrix.charAt(((row1 - 1) % 5 * 5 + col1));
            } else if (row1 == row2) {
                chr1 = matrix.charAt(row1 * 5 + ((col1 - 1) % 5));
                chr2 = matrix.charAt(row2 * 5 + ((col2 - 1) % 5));
            } else {
                chr1 = matrix.charAt(row1 * 5 + col2);
                chr2 = matrix.charAt(row2 * 5 + col1);
            }
            ciphertext.append(Character.toString(chr1)).append(Character.toString(chr2));
        }

        return ciphertext.toString();
    }
}
