package by.mrk.neetcode.level1.arrays;

import java.util.stream.IntStream;

/**
 * <a href="https://neetcode.io/problems/valid-sudoku/question">Valid Sudoku</a>
 */
public class Solution8 {

    private static final int[] UNIQUE_HASH_ADJUSTERS = IntStream.iterate(1, n -> n * 10).limit(9).toArray();
    private static final int SUDOKU_SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        int[] rowBuckets = new int[SUDOKU_SIZE];
        int[] columnBuckets = new int[SUDOKU_SIZE];
        int[] boxBuckets = new int[SUDOKU_SIZE];

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                char value = board[i][j];

                if (value == '.') {
                    continue;
                }

                int numericIndex = Character.getNumericValue(value) - 1;
                int delta = UNIQUE_HASH_ADJUSTERS[numericIndex];
                int boxIndex = findBoxIndex(i, j);

                if (isInvalidHash(rowBuckets, i, delta, numericIndex)) {
                    return false;
                }
                if (isInvalidHash(columnBuckets, j, delta, numericIndex)) {
                    return false;
                }
                if (isInvalidHash(boxBuckets, boxIndex, delta, numericIndex)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Sudoku has 9 boxes [3 x 3] we find which box to analyze
    private int findBoxIndex(int i, int j) {
        return ((i / 3) * 3) + (j / 3);
    }

    private boolean isInvalidHash(int[] buckets, int i, int delta, int numericIndex) {
        buckets[i] += delta;

        return hasDuplicationsOfNumberBasedOnHash(buckets[i], numericIndex);
    }

    // Just a simple mathematics function to extract number at integer position
    private boolean hasDuplicationsOfNumberBasedOnHash(int number, int position) {
        int numberOfZerosToRemove = (int) Math.pow(10, position);
        int numberWithoutZeros = number / numberOfZerosToRemove;

        return numberWithoutZeros % 10 != 1;
    }
}
