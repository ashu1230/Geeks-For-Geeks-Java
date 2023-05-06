You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
Take the prefix of the string of length k and append the reverse of it to itself.
Your task is to find the lexicographically smallest string you can get.

Example 1:

Input:
str = "bvdfndkn"
Output:
bb
Explanation:
"bb" is the lexicographically smallest string you can get. If you choose k>1 the order of the resulting string will increase.

Example 2:

Input:
str = "casd"
Output:
caac
Explanation:
"caac" is the lexicographically smallest string you can get.
Your Task:
You don't need to read input or print anything. Your task is to complete the function stringMirror() which takes a String str as input, and returns the lexicographically smallest string.

Expected Time Complexity: O(|str|)
Expected Space Complexity: O(|str|)

Constraints:
1 <= |str| <= 10^5


#SOLUTION....
  class Solution {
    public static String stringMirror(String str) {
        String ans = "";
        int i = 1;
        ans += str.charAt(0) + "";
        for (i = 1; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(i-1)) break;
            if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(0)) 
                break;
            ans += str.charAt(i) + "";
        }
        return ans + rev(ans);
    }
    private static String rev(String str) {
        String ans = "";
        for (char ch : str.toCharArray()) ans = ch + ans;
        return ans;
        // code here
    }
}
