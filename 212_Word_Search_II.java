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

        TreeNode trie = new TreeNode();

        // build trie
        for (String word: words) {
            trie.add(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean [][] visited = new boolean[rows][cols];;

        List<String> result = new ArrayList<>();


        // perform dfs from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs("", result, board, i, j, trie, visited);
            }
        }

        return result;
    }

    private void dfs(String prefix, List<String> result, char[][] board, int i, int j, TreeNode node, boolean[][] visited) {
        if (i < 0 || i >= board.length) return ;
        if (j < 0 || j >= board[i].length) return ;
        if (visited[i][j]) return ;

        node = node.get(board[i][j]);
        if (node == null) return ;

        visited[i][j] = true;
        prefix += board[i][j];
        
        if (node.isWord()) {
            result.add(prefix);
            
            // to avoid duplicate words in result, mark it as not word
            node.resetWord();
        }
        
        // recursive call to neighbours
        dfs(prefix, result, board, i-1, j, node, visited);
        dfs(prefix, result, board, i+1, j, node, visited);
        dfs(prefix, result, board, i, j-1, node, visited);
        dfs(prefix, result, board, i, j+1, node, visited);
        
        // remove as visited
        visited[i][j] = false;
    }




    private class TreeNode {
        private static int BRANCHING_FACTOR = 26; // number of letters

        // 26-array tree
        TreeNode[] children;
        private boolean isWord;

        public TreeNode() {
            children = new TreeNode[BRANCHING_FACTOR];
            isWord = false;
        }

        public boolean isWord() {
            return isWord;
        }

        public void resetWord() {
            isWord = false;
        }

        public TreeNode get(char c) {
            return children[c -'a'];
        }

        public TreeNode putIfAbsent(char c) {
            c -= 'a';   // convert letter from 0 to 25
            if (children[c] == null) {
                children[c] = new TreeNode();
            }
            return children[c];
        }

        public void add(String word) {
            TreeNode temp = this;
            for (int i = 0; i < word.length(); i++) {
                temp = temp.putIfAbsent(word.charAt(i));
            }
            temp.isWord = true;
        }
    }
}