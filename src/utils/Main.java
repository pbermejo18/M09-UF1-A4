package utils;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Exercici 5
        try {
            // Llegeixo el fitxer
            Path path = Paths.get("textE5");
            byte[] textenbytes = Files.readAllBytes(path);

            // Creo una nova key
            SecretKey KeyE5 = Xifrar.keygenKeyGeneration(128);

            // Encripto l'informació del fitxer y ho imprimo
            byte[] array_encriptat = Xifrar.encryptData(KeyE5, textenbytes);
            System.out.println("*********** E5 - Encriptat ***********");
            String string2 = new String(array_encriptat, StandardCharsets.UTF_8);
            System.out.println(string2);

            // Desencripto l'informació de l'array encriptat y ho imprimo
            byte[] array_desencriptat = Xifrar.decryptData(array_encriptat, KeyE5);
            System.out.println("********** E5 - Desencriptat **********");
            String string = new String(array_desencriptat, StandardCharsets.UTF_8);
            System.out.println(string);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Exercici 6
        try {
            Path path = Paths.get("textE6");
            byte[] textenbytes = Files.readAllBytes(path);

            SecretKey keyE6 = Xifrar.passwordKeyGeneration("pas",256);

            byte[] e6encrypt = Xifrar.encryptData(keyE6, textenbytes);
            System.out.println("*********** E6 - Encriptat ***********");
            String string_enc = new String(e6encrypt, StandardCharsets.UTF_8);
            System.out.println(string_enc);

            byte[] e6decrypt = Xifrar.decryptData(e6encrypt, keyE6);
            System.out.println("********** E6 - Desencriptat **********");
            String string_dec = new String(e6decrypt, StandardCharsets.UTF_8);
            System.out.println(string_dec);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Exercici 8
        try {
            Path path = Paths.get("textE8");
            byte[] textenbytes = Files.readAllBytes(path);

            SecretKey keyE6 = Xifrar.passwordKeyGeneration("pas",256);
            SecretKey key_diferente = Xifrar.passwordKeyGeneration("IESPuigCastellar", 256);

            byte[] e6encrypt = Xifrar.encryptData(keyE6, textenbytes);
            System.out.println("*********** E8 - Encriptat ***********");
            String string_enc = new String(e6encrypt, StandardCharsets.UTF_8);
            System.out.println(string_enc);

            byte[] e6decrypt = Xifrar.decryptData(e6encrypt, key_diferente);
            System.out.println("********** E8 - Desencriptat **********");
            String string_dec = new String(e6decrypt, StandardCharsets.UTF_8);
            System.out.println(string_dec);

        } catch (IOException e) {
            e.printStackTrace();
        } /* catch (BadPaddingException paddingException) {
            System.out.println(paddingException);
        } */
    }
}