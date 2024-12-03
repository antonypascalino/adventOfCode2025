package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.AdventOfCodeUtilities.ReadPuzzle;

public class Day2 {

    public void first() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "(\\d+ *)+";
        Pattern pattern = Pattern.compile(regex);

        Integer safeLines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                long[] numbers = Arrays.stream(matcher.group(0).split(" +")).mapToLong(Long::parseLong).toArray();
                boolean increasing = numbers[0] <= numbers[1];
                boolean safe = true;
                for (int i = 1; i < numbers.length; i++) {
                    if (increasing) {
                        if (numbers[i] - numbers[i - 1] > 3 || numbers[i] - numbers[i - 1] < 1) {
                            safe = false;
                            break;
                        }
                    } else {
                        if (numbers[i - 1] - numbers[i] > 3 || numbers[i - 1] - numbers[i] < 1) {
                            safe = false;
                            break;
                        }
                    }
                }
                if (safe) safeLines++;
            }
        }
        System.out.println(safeLines);
    }

    public void second() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "(\\d+ *)+";
        Pattern pattern = Pattern.compile(regex);

        Integer safeLines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                List<Long> numbersOriginal = Arrays.stream(matcher.group(0).split(" +"))
                        .map(Long::parseLong)
                        .toList();

                int size = numbersOriginal.size();
                boolean safe = true;
                for (int j = -1; j < size; j++) {
                    List<Long> numbers = new ArrayList<>(numbersOriginal);
                    if (!safe) {
                        numbers.remove(j);
                        safe = true;
                    }

                    boolean increasing = numbers.get(0) <= numbers.get(1);
                    for (int i = 1; i < numbers.size(); i++) {
                        if (increasing) {
                            if (numbers.get(i) - numbers.get(i - 1) > 3 || numbers.get(i) - numbers.get(i - 1) < 1) {
                                safe = false;
                                break;
                            }
                        } else {
                            if (numbers.get(i - 1) - numbers.get(i) > 3 || numbers.get(i - 1) - numbers.get(i) < 1) {
                                safe = false;
                                break;
                            }
                        }
                    }
                    if (safe) {
                        safeLines++;
                        break;
                    }
                }
            }
        }
        System.out.println(safeLines);
    }
}
