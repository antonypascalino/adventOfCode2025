package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdventOfCodeUtilities {

    public static String ReadPuzzle(String fileName) {

        String puzzle = "";
        try {
            puzzle = new String(Files.readAllBytes(Paths.get("src/puzzles/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puzzle;
    }
}
