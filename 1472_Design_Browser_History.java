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

class BrowserHistory {
    
    // Stack to store the URLs visited after the current page
    Stack<String> forwardHistory;
    
    // Stack to store the URLs visited before the current page
    Stack<String> backwardHistory;
    
    // The current page URL
    String currentPage;

    // Constructor to initialize the browser with a homepage
    public BrowserHistory(String homepage) {
        forwardHistory = new Stack<>();
        backwardHistory = new Stack<>();
        currentPage = homepage;
    }
    
    // Method to visit a new page
    public void visit(String url) {
        
        // Clear the forward history since we are starting a new chain of visited URLs
        forwardHistory.clear();

        // Add the current page to the backward history and set the current page to the new URL
        backwardHistory.push(currentPage);
        currentPage = url;
    }
    
    // Method to move backward by a certain number of steps
    public String back(int steps) {
        // Move back by popping URLs from the backward history and pushing them onto the forward history
        while (steps > 0 && !backwardHistory.isEmpty()) {
            forwardHistory.push(currentPage);
            currentPage = backwardHistory.pop();
            steps--;
        }
        
        // Return the current page after moving back
        return currentPage;
    }
    
    // Method to move forward by a certain number of steps
    public String forward(int steps) {
        // Move forward by popping URLs from the forward history and pushing them onto the backward history
        while (steps > 0 && !forwardHistory.isEmpty()) {
            backwardHistory.push(currentPage);
            currentPage = forwardHistory.pop();
            steps--;
        }
        
        // Return the current page after moving forward
        return currentPage;
    }
}
