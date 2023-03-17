// id: 79
// Name: Word Search
// link: https://leetcode.com/problems/word-search/
// Difficulty: Medium
/**
 * A class that checks if a given word can be formed by a sequence of adjacent characters
 * in a two-dimensional char array.
 */
class Solution {
    
    /**
     * Checks if the given word can be formed by a sequence of adjacent characters
     * in the provided board.
     *
     * @param board the two-dimensional char array representing the board
     * @param word the word to search for in the board
     * @return true if the word can be formed by a sequence of adjacent characters
     *         in the board, false otherwise
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Check each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Performs a depth-first search to find the given word in the board starting
     * from the specified cell.
     *
     * @param board the two-dimensional char array representing the board
     * @param visited a two-dimensional boolean array indicating which cells
     *                have already been visited during the search
     * @param word the word to search for in the board
     * @param index the current index in the word that we are searching for
     * @param i the row index of the current cell being searched
     * @param j the column index of the current cell being searched
     * @return true if the word can be found starting from the current cell,
     *         false otherwise
     */
    boolean dfs(char[][] board, boolean[][] visited, String word, int index, int i, int j) {

        // Base cases
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        
        // don't move forward if word not matching
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        visited[i][j] = true;

        // Check the neighbors recursively
        if (dfs(board, visited, word, index + 1, i - 1, j) ||
            dfs(board, visited, word, index + 1, i + 1, j) ||
            dfs(board, visited, word, index + 1, i, j - 1) ||
            dfs(board, visited, word, index + 1, i, j + 1)) {
            return true;
        }

        // Mark the current cell as unvisited
        visited[i][j] = false;

        return false;
    }
}
