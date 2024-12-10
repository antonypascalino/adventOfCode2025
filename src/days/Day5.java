package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.AdventOfCodeUtilities.ReadPuzzle;

public class Day5 {

    public void first() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String ruleRegex = "\\d+\\|\\d+";
        String pageRegex = "\\d+[,\\d+]+";
        Pattern rulePattern = Pattern.compile(ruleRegex);
        Pattern pagePattern = Pattern.compile(pageRegex);

        long result = 0;
        Map<Integer, ArrayList<Integer>> rules = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher ruleMatcher = rulePattern.matcher(line);
            Matcher pageMatcher = pagePattern.matcher(line);

            if (ruleMatcher.find()) {
                String[] numbers = line.split("\\|");
                rules.computeIfAbsent(Integer.parseInt(numbers[0]), k -> new ArrayList<>()).add(Integer.parseInt(numbers[1]));
                continue;
            }
            readUpdate:
            while (pageMatcher.find()) {
                ArrayList<Integer> update = new ArrayList<>();
                String[] numbers = pageMatcher.group(0).split(",");
                for (String number : numbers) {
                    update.add(Integer.parseInt(number));
                }
                for (int i = update.size() - 1; i > 0; i--) {
                    if (rules.get(update.get(i)) != null) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (rules.get(update.get(i)).contains(update.get(j))) {
                                continue readUpdate;
                            }
                        }
                    }
                }
                result += update.get(update.size() / 2);

            }
        }
        System.out.println(result);
    }

    public void second() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String ruleRegex = "\\d+\\|\\d+";
        String pageRegex = "\\d+[,\\d+]+";
        Pattern rulePattern = Pattern.compile(ruleRegex);
        Pattern pagePattern = Pattern.compile(pageRegex);

        long result = 0;
        Map<Integer, ArrayList<Integer>> rules = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher ruleMatcher = rulePattern.matcher(line);
            Matcher pageMatcher = pagePattern.matcher(line);

            if (ruleMatcher.find()) {
                String[] numbers = line.split("\\|");
                rules.computeIfAbsent(Integer.parseInt(numbers[0]), k -> new ArrayList<>()).add(Integer.parseInt(numbers[1]));
                continue;
            }

            while (pageMatcher.find()) {
                ArrayList<Integer> update = new ArrayList<>();
                String[] numbers = pageMatcher.group(0).split(",");
                for (String number : numbers) {
                    update.add(Integer.parseInt(number));
                }

                boolean reordered = false;
                boolean ordered;
                do {
                    ordered = true;
                    // Check for out-of-order elements and reorder
                    for (int i = update.size() - 1; i > 0; i--) {
                        int current = update.get(i);
                        ArrayList<Integer> dependencies = rules.get(current);

                        if (dependencies != null) {
                            int toBeBefore = -1;
                            for (int j = i - 1; j >= 0; j--) {
                                if (dependencies.contains(update.get(j))) {
                                    ordered = false;
                                    reordered = true;
                                    toBeBefore = j;
                                }
                            }
                            if (toBeBefore != -1) {
                                update.remove(i);
                                update.add(toBeBefore, current);
                                break;
                            }
                        }
                    }
                } while (!ordered);
                if (reordered) {
                    result += update.get(update.size() / 2);
                }
            }

        }
        System.out.println(result);
    }
}
