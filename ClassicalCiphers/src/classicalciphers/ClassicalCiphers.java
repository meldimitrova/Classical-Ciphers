/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicalciphers;

import static classicalciphers.VigenereCipher.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class Name:    Caesar Cipher
 * @author Melina Dimitrova
 * @version 1
 * 
 * Class Description: Main method class to test the
 * encryption and decryption techniques of each cipher class.
 */

public class ClassicalCiphers {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Plaintext and keyword for usage in the ciphers
        String plaintext = "encryption algorithm".toUpperCase();
        String keyword = "cryptography".toUpperCase();

        System.out.println("Plaintext : " + plaintext);
        System.out.println("Keyword : " + keyword);

        // Caesar Cipher
        CaesarCipher ceasar = new CaesarCipher();
        String ciphertext = ceasar.setShift((byte) 3).encrypt(plaintext).toUpperCase();
        System.out.println("\n--Ceaser Cipher");
        System.out.println("Encryption : " + ciphertext.toUpperCase());
        System.out.println("Decryption : " + ceasar.setShift((byte) 3).decrypt(ciphertext).toUpperCase());

        // Atbash Cipher
        AtbashCipher a = new AtbashCipher();
        String atbash = a.encrypt(plaintext);
        System.out.println("\n--Atbash Cipher");
        System.out.println("Encryption : " + atbash);
        System.out.println("Decryption : " + a.decrypt(atbash));

        // Vigenere Cipher
        String key = generateKey(plaintext, keyword);
        String cipher_text = cipherText(plaintext, key);
        System.out.println("\n--Vigenere Cipher");
        System.out.println("Encryption : " + cipher_text);
        System.out.println("Decryption : " + originalText(cipher_text, key));

        // Playfair Cipher
        PlayfairCipher pf = new PlayfairCipher();

        String matrix = pf.generateMatrix(keyword.replace(" ", "").toUpperCase());
        String[] pairs = pf.divideToPairs(plaintext.replace("j", "i").toUpperCase());

        System.out.println("\n--Playfair Cipher");
        System.out.println("Keyword  : " + keyword);
        System.out.print("Generated matrix :  ");
        char chrs[] = matrix.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            if (i % 5 == 0 & i != 0) {
                System.out.println("");
            }
            System.out.print(chrs[i]);
        }

        String pfciphertext = pf.encrypt(pairs, matrix).toUpperCase();
        System.out.println("\nEncryption: " + pfciphertext);
        System.out.println("Decryption : " + pf.decrypt(pf.divideToPairs(pfciphertext),
                matrix).toUpperCase());

        
        // Load files to use for encryption
        System.out.println("\n--File reader--");
        
        File fileSherlock = new File("txt\\Sherlock.txt");
        File fileMC = new File("txt\\Monte Cristo.txt");
        Scanner scS = new Scanner(fileSherlock);
        Scanner scM = new Scanner(fileMC);
        String fs = "";
        String fm = "";

        while (scS.hasNextLine() || scM.hasNextLine()) {
            fs += scS.nextLine();
            fm += scM.nextLine();
            System.out.println(fs + "\n\n" + fm);
        }

        // Encrypt with Ceaser Cipher
        String ceaserSH = ceasar.setShift((byte) 8).encrypt(fs).toUpperCase();
        System.out.println("\n--Ceaser Cipher from File");
        System.out.println("Encryption : " + ceaserSH.toUpperCase());
        System.out.println("Decryption : " + ceasar.setShift((byte) 8).decrypt(ceaserSH).toUpperCase());

        String ceaserM = ceasar.setShift((byte) 5).encrypt(fm).toUpperCase();
        System.out.println("Encryption : " + ceaserM.toUpperCase());
        System.out.println("Decryption : " + ceasar.setShift((byte) 5).decrypt(ceaserM).toUpperCase());

       
    }

}
