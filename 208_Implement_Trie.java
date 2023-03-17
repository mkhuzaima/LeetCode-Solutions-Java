// id: 208
// Name: Implement Trie (Prefix Tree)
// link: https://leetcode.com/problems/implement-trie-prefix-tree/
// Difficulty: Medium

class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {

        TreeNode node = root;
        // add a branch for word
        for (int i = 0; i < word.length(); i++) {
            node = node.putIfAbsent(word.charAt(i));
        }
        // set this to word
        node.isWord = true;
    }

    public boolean search(String word) {
        TreeNode node = helperSearch(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        // root.printAllWords("");
        TreeNode node = helperSearch(prefix);
        return node != null;
    }


    private TreeNode helperSearch(String s) {
        TreeNode node = root;

        // check whether this branch exists
        for (int i = 0; node != null && i < s.length(); i++) {
            node = node.get(s.charAt(i));
        }
        return node;
    }

    private class TreeNode {
        private static int BRANCHING_FACTOR = 26; // number of letters
        // 26-array tree
        TreeNode[] children;
        boolean isWord;

        public TreeNode() {
            children = new TreeNode[BRANCHING_FACTOR];
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

        // public void printAllWords(String prefix) {
        //     for (int i = 0; i < BRANCHING_FACTOR; i++) {
        //         if (children[i] != null) {
        //             children[i].printAllWords(prefix + (char)(i+'a'));
        //         }
        //     }
        //     if (isWord) System.out.println(prefix);
        // }
    }
}