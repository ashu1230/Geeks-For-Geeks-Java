Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. Now if it is possible to make the string S a palindrome after replacing all '?' then find the palindromic string with a minimum ascii sum of the absolute difference of adjacent characters. Otherwise, return -1.

Example 1:

Input: S = a???c??c????
Output: 4
Explanation:
We can see that we can make the string
palindrome. Now to get minimum ascii sum we should
replace all the '?' between 'a' and 'c' with
'b' and all the '?' between two 'c' with 'c'.
So after replacing all the '?' the string: 
abbbccccbbba.
The sum of differences of adjacent characters is 4.   
Example 2:

Input: S = a???c??c???c
Output: -1
Explanation:
It is not possible to make the string palindrome.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minimumSum() which takes a string S input parameter and returns an integer denoting the sum of differences of adjacent characters. If it is not possible to make string palindrome, return -1. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |S| <= 10^5


#SOLUTION....
  class Solution {
    public static int minimumSum(String S) {
        // code here
        char [] s = S.toCharArray();
        int l = 0;
        int r = s.length -1;
        while(l<r){
            if(s[l] == s[r]) {
                l++;
                r--;
                continue;
            }
            else if(s[l] == '?' &&  s[r] != '?') s[l] = s[r];
            else if(s[l] != '?' && s[r] == '?') s[r] = s[l];
            else return -1;
            l++;
            r--;
        }
        int diff = 0;
        char curr = s[0];
        char prev = s[0];
        // for(char i : s) System.out.print(i);
        for(int i = 0; i<=s.length/2;i++){
            if(s[i]!='?') {
                prev = curr;
                curr = s[i];
                if(prev!= '?')diff += Math.abs(prev- curr);
            }
        }
        return 2*diff;
    }
}
