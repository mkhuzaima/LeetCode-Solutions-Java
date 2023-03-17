// id: 211
// Name: Design Add and Search Words Data Structure
// link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Difficulty: Medium

class WordDictionary {

    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.putIfAbsent(word.charAt(i));
        }
        node.setWord();
    }

    public boolean search(String word) {
        return root.search(word, 0);
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
        public void setWord () {
            isWord = true;
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

        public boolean search(String word, int index) {
            if (index >= word.length()) return isWord;

            TreeNode node = root;

            if (word.charAt(index) == '.') {
                // search among each children recursively
                for (TreeNode child: children) {
                    if (child != null && child.search(word, index + 1) ) {
                        return true;
                    }
                }
            }
            else {
                // search for only given child
                TreeNode child = get(word.charAt(index));
                if (child != null && child.search(word, index + 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}