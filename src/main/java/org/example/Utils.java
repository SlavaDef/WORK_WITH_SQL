package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public static String readSQL(String filName){

        try {
            return Files.readString(Path.of(filName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
