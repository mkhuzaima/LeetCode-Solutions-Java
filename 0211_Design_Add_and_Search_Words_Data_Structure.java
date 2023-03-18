/*
 * 211. Design Add and Search Words Data Structure
 * Problem Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class WordDictionary {

    TreeNode root;

    // Constructor to initialize the root node of the trie
    public WordDictionary() {
        root = new TreeNode();
    }

    // Method to add a new word to the trie
    public void addWord(String word) {
        TreeNode node = root;
        // Traverse the trie to add each character of the word
        for (int i = 0; i < word.length(); i++) {
            node = node.putIfAbsent(word.charAt(i));
        }
        // Mark the last node as a word
        node.setWord();
    }

    // Method to search for a word in the trie
    public boolean search(String word) {
        // Start searching from the root node
        return root.search(word, 0);
    }


    private class TreeNode {
        // Define the number of letters in the alphabet
        private static int BRANCHING_FACTOR = 26;

        // Array to store the children of the node
        TreeNode[] children;
        // Flag to indicate if the node represents a complete word
        private boolean isWord;

        // Constructor to initialize a new node
        public TreeNode() {
            children = new TreeNode[BRANCHING_FACTOR];
            isWord = false;
        }

        // Getter method to check if the node represents a complete word
        public boolean isWord() {
            return isWord;
        }
        
        // Setter method to mark a node as a complete word
        public void setWord () {
            isWord = true;
        }

        // Method to get the child node for a given character
        public TreeNode get(char c) {
            return children[c -'a'];
        }

        // Method to add a child node for a given character, if it doesn't exist
        public TreeNode putIfAbsent(char c) {
            c -= 'a';   // Convert the letter from 0 to 25
            if (children[c] == null) {
                children[c] = new TreeNode();
            }
            return children[c];
        }

        // Method to search for a word in the trie
        public boolean search(String word, int index) {
            // If we've reached the end of the word, check if the node represents a complete word
            if (index >= word.length()) return isWord;

            // Start searching for the next character from this node
            TreeNode node = root;

            // If the next character is a '.', search among each child recursively
            if (word.charAt(index) == '.') {
                for (TreeNode child: children) {
                    if (child != null && child.search(word, index + 1) ) {
                        return true;
                    }
                }
            }
            // If the next character is not a '.', search for only the given child
            else {
                TreeNode child = get(word.charAt(index));
                if (child != null && child.search(word, index + 1)) {
                    return true;
                }
            }

            // The word was not found in the trie
            return false;
        }
    }
}