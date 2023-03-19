/*
 * 37. Sudoku Solver
 * Problem Link: https://leetcode.com/problems/sudoku-solver/
 * Difficulty:   Hard
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    // Keep track of whether the sudoku puzzle is completed
    boolean completed = false;

    public void solveSudoku(char[][] board) {
        // Iterate through each cell in the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Skip cells that already have a value
                if (board[row][col] != '.') {
                    continue;
                }

                // Check all possible values for the current cell
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(board, row, col, val)) {
                        // If the value is valid, set it in the board and recursively call solveSudoku
                        board[row][col] = val;
                        
                        solveSudoku(board);

                        // If the puzzle is completed, return
                        if (completed) {
                            return;
                        }

                        // If the puzzle is not completed, unset the current cell and try the next value
                        board[row][col] = '.';
                    }
                }

                // If no value is valid for the current cell, return to the previous cell
                return;
            }
        }

        // If all cells have been filled, the puzzle is completed
        completed = true;
    }

    private boolean isValid(char [][] board, int row, int col, char val) {
        // Check if the value is unique in the current row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val) {
                return false;
            }
        }

        // Check if the value is unique in the current 3x3 grid
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowStart+i][colStart+j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}