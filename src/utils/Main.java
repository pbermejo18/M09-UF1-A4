package utils;

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
            byte[] array_desencriptat = Xifrar.decryptData(array_encriptat,KeyE5);
            System.out.println("********** E5 - Desencriptat **********");
            String string = new String(array_desencriptat, StandardCharsets.UTF_8);
            System.out.println(string);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}