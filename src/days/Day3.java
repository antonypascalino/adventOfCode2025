package days;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.AdventOfCodeUtilities.ReadPuzzle;

public class Day3 {

    public void first() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);

        long result = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {

                String numberRegex = "\\d+";
                Pattern numberPattern = Pattern.compile(numberRegex);
                Matcher numberMatcher = numberPattern.matcher(matcher.group(0));

                if (numberMatcher.find()) {
                    long first = Long.parseLong(numberMatcher.group(0));
                    if (numberMatcher.find()) {
                        long second = Long.parseLong(numberMatcher.group(0));
                        result += first * second;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public void second() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);

        long result = 0;

        StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine());
        }

            String[] validLines = input.toString().split("don't\\(\\).*?do\\(\\)");

            for(String line: validLines) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {

                    String numberRegex = "\\d+";
                    Pattern numberPattern = Pattern.compile(numberRegex);
                    Matcher numberMatcher = numberPattern.matcher(matcher.group(0));

                    if (numberMatcher.find()) {
                        long first = Long.parseLong(numberMatcher.group(0));
                        if (numberMatcher.find()) {
                            long second = Long.parseLong(numberMatcher.group(0));
                            result += first * second;
                        }
                    }
                }
            }
        System.out.println(result);
    }

}
