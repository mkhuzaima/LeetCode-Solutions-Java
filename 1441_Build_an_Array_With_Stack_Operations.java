// id: 1441
// Name: Build an Array With Stack Operations
// link: https://leetcode.com/problems/build-an-array-with-stack-operations/
// Difficulty: Medium

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int j = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n && j < target.length; i++) {
            if (i == target[j] ) {
                result.add("Push");
                j++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }


        return result;

    }
}
