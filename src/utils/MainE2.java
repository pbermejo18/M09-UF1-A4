package utils;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainE2 {
    public static void main(String[] args) {
        try {
            // Llegeixo el fitxer
            Path path = Paths.get("textamagat");
            byte[] textenbytes = Files.readAllBytes(path);

            File file = new File("claus");
            FileReader fileReader = new FileReader(file);
            BufferedReader br =  new BufferedReader(fileReader);
            String line = br.readLine();
            while(line != null) {
                SecretKey key = Xifrar.passwordKeyGeneration(line,128);

                byte[] array_desencriptat = Xifrar.decryptData(textenbytes, key);
                if (array_desencriptat != null) {
                    String string = new String(array_desencriptat, StandardCharsets.UTF_8);
                    System.out.println("\033[1;97mLa contrasenya és: " + line);
                    System.out.println("Missatge: " + string);
                } else System.out.println("\033[1;91mPassword incorrecte: " + line);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}