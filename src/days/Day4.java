package days;

import java.util.ArrayList;
import java.util.Scanner;

import static utilities.AdventOfCodeUtilities.ReadPuzzle;

public class Day4 {

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT,
    }

    public void first() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        ArrayList<ArrayList<Character>> puzzleMatrix = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Character> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                row.add(line.charAt(i));
            }
            puzzleMatrix.add(row);
        }

        int xmasCount = 0;

        for (int i = 0; i < puzzleMatrix.size(); i++) {
            for (int j = 0; j < puzzleMatrix.get(i).size(); j++) {
                if (puzzleMatrix.get(i).get(j) == 'X') {
                    ArrayList<Direction> directions = searchForM(puzzleMatrix, i, j);
                    for (Direction direction : directions)
                        switch (direction) {
                            case UP:
                                if (i - 2 >= 0 && puzzleMatrix.get(i - 2).get(j) == 'A' && i - 3 >= 0 && puzzleMatrix.get(i - 3).get(j) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case DOWN:
                                if (i + 2 < puzzleMatrix.size() && puzzleMatrix.get(i + 2).get(j) == 'A' && i + 3 < puzzleMatrix.size() && puzzleMatrix.get(i + 3).get(j) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case LEFT:
                                if (j - 2 >= 0 && puzzleMatrix.get(i).get(j - 2) == 'A' && j - 3 >= 0 && puzzleMatrix.get(i).get(j - 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case RIGHT:
                                if (j + 2 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i).get(j + 2) == 'A' && j + 3 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i).get(j + 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case UP_LEFT:
                                if (i - 2 >= 0 && j - 2 >= 0 && puzzleMatrix.get(i - 2).get(j - 2) == 'A' && i - 3 >= 0 && j - 3 >= 0 && puzzleMatrix.get(i - 3).get(j - 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case UP_RIGHT:
                                if (i - 2 >= 0 && j + 2 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i - 2).get(j + 2) == 'A' && i - 3 >= 0 && j + 3 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i - 3).get(j + 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case DOWN_LEFT:
                                if (i + 2 < puzzleMatrix.size() && j - 2 >= 0 && puzzleMatrix.get(i + 2).get(j - 2) == 'A' && i + 3 < puzzleMatrix.size() && j - 3 >= 0 && puzzleMatrix.get(i + 3).get(j - 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                            case DOWN_RIGHT:
                                if (i + 2 < puzzleMatrix.size() && j + 2 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i + 2).get(j + 2) == 'A' && i + 3 < puzzleMatrix.size() && j + 3 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i + 3).get(j + 3) == 'S') {
                                    xmasCount++;
                                }
                                break;
                        }
                }
            }

        }
        System.out.println(xmasCount);
    }

    public void second() {

        String puzzle = ReadPuzzle(this.getClass().getSimpleName());
        Scanner scanner = new Scanner(puzzle);

        ArrayList<ArrayList<Character>> puzzleMatrix = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Character> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                row.add(line.charAt(i));
            }
            puzzleMatrix.add(row);
        }

        int xmasCount = 0;

        for (int i = 1; i < puzzleMatrix.size() - 1; i++) {
            for (int j = 1; j < puzzleMatrix.get(i).size() - 1; j++) {
                if (puzzleMatrix.get(i).get(j) == 'A' && (
                            puzzleMatrix.get(i - 1).get(j - 1) == 'M' && puzzleMatrix.get(i + 1).get(j + 1) == 'S' ||
                            puzzleMatrix.get(i - 1).get(j - 1) == 'S' && puzzleMatrix.get(i + 1).get(j + 1) == 'M'
                ) && (
                            puzzleMatrix.get(i - 1).get(j + 1) == 'M' && puzzleMatrix.get(i + 1).get(j - 1) == 'S' ||
                            puzzleMatrix.get(i - 1).get(j + 1) == 'S' && puzzleMatrix.get(i + 1).get(j - 1) == 'M' )

                ) xmasCount++;
            }
        }
        System.out.println(xmasCount);
    }




private ArrayList<Direction> searchForM(ArrayList<ArrayList<Character>> puzzleMatrix, int i, int j) {

    ArrayList<Direction> directions = new ArrayList<>();

    if (i - 1 >= 0 && puzzleMatrix.get(i - 1).get(j) == 'M') {
        directions.add(Direction.UP);
    }
    if (i + 1 < puzzleMatrix.size() && puzzleMatrix.get(i + 1).get(j) == 'M') {
        directions.add(Direction.DOWN);
    }
    if (j - 1 >= 0 && puzzleMatrix.get(i).get(j - 1) == 'M') {
        directions.add(Direction.LEFT);
    }
    if (j + 1 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i).get(j + 1) == 'M') {
        directions.add(Direction.RIGHT);
    }
    if (i - 1 >= 0 && j - 1 >= 0 && puzzleMatrix.get(i - 1).get(j - 1) == 'M') {
        directions.add(Direction.UP_LEFT);
    }
    if (i - 1 >= 0 && j + 1 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i - 1).get(j + 1) == 'M') {
        directions.add(Direction.UP_RIGHT);
    }
    if (i + 1 < puzzleMatrix.size() && j - 1 >= 0 && puzzleMatrix.get(i + 1).get(j - 1) == 'M') {
        directions.add(Direction.DOWN_LEFT);
    }
    if (i + 1 < puzzleMatrix.size() && j + 1 < puzzleMatrix.get(i).size() && puzzleMatrix.get(i + 1).get(j + 1) == 'M') {
        directions.add(Direction.DOWN_RIGHT);
    }
    return directions;
}
}



