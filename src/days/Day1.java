package days;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.AdventOfCodeUtilities.ReadPuzzle;

public class Day1 {

    public void first() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "^(\\d+ *\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] numbers = matcher.group(0).split(" +");
                firstList.add(Integer.parseInt(numbers[0]));
                secondList.add(Integer.parseInt(numbers[1]));
            }
        }

        firstList = firstList.stream().sorted().toList();
        secondList = secondList.stream().sorted().toList();

        Integer distances = 0;

        for (int i = 0; i < firstList.size(); i++) {
            distances += Math.abs(firstList.get(i) - secondList.get(i));
        }

        System.out.println(distances);

    }

    public void second() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        String regex = "^(\\d+ *\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] numbers = matcher.group(0).split(" +");
                firstList.add(Integer.parseInt(numbers[0]));
                secondList.add(Integer.parseInt(numbers[1]));
            }
        }

        firstList = firstList.stream().sorted().toList();
        secondList = secondList.stream().sorted().toList();

        Long result = 0L;

        for (Integer i : firstList) {
            Long count = secondList.stream().filter(i::equals).count();
            result += (i * count);
        }

        System.out.println(result);
    }


}
