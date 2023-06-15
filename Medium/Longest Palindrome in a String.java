Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string that reads the same backward. More formally, S is a palindrome if reverse(S) = S. In case of conflict, return the substring which occurs first ( with the least starting index).

Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.

Expected Time Complexity: O(|S|2).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 103
  
  class Solution{
    static String longestPalin(String s){
        int MOD = (int)1e9 + 7;
        int p = 31;
        int max = Integer.MIN_VALUE;
        int l = -1,r = -1;
        for(int i = 0;i < s.length();i++){
            long hash = 0;
            long revHash = 0;
            long curr = p;
            for(int j = i;j < s.length();j++){
                int c = s.charAt(j) - 'a';
                hash = (hash + (c * curr) % MOD) % MOD;
                curr = (curr * p) % MOD;
                revHash = ((revHash * p) % MOD + (c * p) % MOD) % MOD;
                if(hash == revHash){
                    if(max < (j - i + 1)){
                        max = j - i + 1;
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l,r + 1);
    }
}
