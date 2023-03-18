/*
 * 1472. Design Browser History
 * Problem Link: https://leetcode.com/problems/design-browser-history/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

// can also be implemented using 2 stacks
class DoublyLinkedListNode {
    String url;           // the URL associated with this node
    DoublyLinkedListNode next;   // reference to the next node
    DoublyLinkedListNode prev;   // reference to the previous node

    public DoublyLinkedListNode(String url, DoublyLinkedListNode prev) {
        this.url = url;
        this.prev = prev;
        next = null;
    }
}

class BrowserHistory {
    // left side of current is backward History
    // right side of current is forward History
    DoublyLinkedListNode current;

    public BrowserHistory(String homepage) {
        current = new DoublyLinkedListNode(homepage, null);
    }
    
    // Add a new node with the given URL to the end of the linked list
    public void visit(String url) {
        current.next = new DoublyLinkedListNode(url, current);
        current = current.next;
    }
    
    // Move the current node back by the given number of steps, and return the URL of the new current node
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    // Move the current node forward by the given number of steps, and return the URL of the new current node
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}