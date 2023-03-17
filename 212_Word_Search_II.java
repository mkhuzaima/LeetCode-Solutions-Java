/*
 * 212. Word Search II
 * Problem Link: https://leetcode.com/problems/word-search-ii/
 * Difficulty:   Hard
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // Initialize trie data structure
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.add(word);
        }

        // Initialize variables
        int numRows = board.length;
        int numCols = board[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        List<String> result = new ArrayList<>();

        // Perform depth first search (DFS) from each cell
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                dfs("", result, board, row, col, root, visited);
            }
        }
        return result;
    }

    private void dfs(String prefix, List<String> result, char[][] board, int row, int col, TrieNode node, boolean[][] visited) {
        // Check if current cell is out of bounds or has already been visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }

        // Check if the current letter exists in the trie
        node = node.get(board[row][col]);
        if (node == null) {
            return;
        }

        // Mark cell as visited and add current letter to prefix
        visited[row][col] = true;
        prefix += board[row][col];

        // If the prefix matches a word in the trie, add it to the result
        if (node.isWord()) {
            result.add(prefix);

            // To avoid duplicate words in result, mark it as not word
            node.resetWord();
        }

        // Recursive calls to neighboring cells
        dfs(prefix, result, board, row - 1, col, node, visited);
        dfs(prefix, result, board, row + 1, col, node, visited);
        dfs(prefix, result, board, row, col - 1, node, visited);
        dfs(prefix, result, board, row, col + 1, node, visited);

        // Mark cell as unvisited
        visited[row][col] = false;
    }

    private class TrieNode {
      private static int BRANCHING_FACTOR = 26; // number of letters

        // 26-array tree
        TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[BRANCHING_FACTOR];
            isWord = false;
        }

        public boolean isWord() {
            return isWord;
        }

        public void resetWord() {
            isWord = false;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public TrieNode putIfAbsent(char c) {
            c -= 'a';   // convert letter from 0 to 25
            if (children[c] == null) {
                children[c] = new TrieNode();
            }
            return children[c];
        }

        public void add(String word) {
            TrieNode temp = this;
            for (int i = 0; i < word.length(); i++) {
                temp = temp.putIfAbsent(word.charAt(i));
            }
            temp.isWord = true;
        }
    }
}