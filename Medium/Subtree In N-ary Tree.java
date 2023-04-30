Given root of a n-ary tree find the number of duplicate subtree in the n-ary tree.
Two trees are duplicate if they have the same structure with the same node values.

Example 1:

Input:
1 N 2 2 3 N 4 N 4 4 3 N N N N N

Output: 2
Explanation: [4], [3] are duplicate subtree.
Example 2:

Input:
1 N 2 3 N 4 5 6 N N N N

Output: 0
Explanation: No duplicate subtree found.
Your Task:
You don't need to read input or print anything. Your task is to complete the function duplicateSubtreeNaryTree() which takes root of n-ary tree as input, and return an integer value as number of duplicate subtrees.
  
  
  
  Quetion link:- https://practice.geeksforgeeks.org/problems/079dee7e7db7a784ed73f604e3cf1712432edf79/1


#Solution Java..
  class Solution {
    private static Map<String, Integer> subtreeCounts;

    public int duplicateSubtreeNaryTree(Node root){
        subtreeCounts = new HashMap<>();
        traverse(root);
        int count = 0;
        for (int freq : subtreeCounts.values()) {
            if (freq > 1) {
                count++;
            }
        }
        return count;
    }

    private static String traverse(Node root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        sb.append(":");
        for (Node child : root.children) {
            sb.append(traverse(child));
            sb.append(",");
        }
        String subtree = sb.toString();
        subtreeCounts.put(subtree, subtreeCounts.getOrDefault(subtree, 0) + 1);
        return subtree;
    }
}

