Given a string s containing 0's and 1's. You have to return the smallest positive integer C, such that the binary string can be cut into C pieces and each piece should be of the power of 5  with no leading zeros.
Note: The string s is a binary string. And if no such cuts are possible, then return -1.

Example 1:

Input:
s = "101101101"
Output: 
3
Explanation: 
We can split the given string into 
three 101s, where 101 is the binary 
representation of 5.
Example 2:

Input:
s = "00000"
Output: 
-1
Explanation: 
0 is not a power of 5.
Your Task:
Your task is to complete the function cuts() which take a single argument(string s). You need not take any input or print anything. Return an int C if the cut is possible else return -1.

Expected Time Complexity: O(|s|*|s|*|s|).
Expected Auxiliary Space: O(|s|).

Constraints:
1<= |s| <=50
  
  #SOLUTION...
  class Solution{
  static int cuts(String s)
    {
        // code here
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp, (int)1e9);
        dp[n] = 0;
        for(int i = n-1; i>=0;i--){
            for(int j = i;j<n;j++){
                if(checkPowerOf5(s.substring(i, j+1))){
                    dp[i] = Math.min(dp[j+1]+1, dp[i]);
                }
            }
        }
        int res = dp[0];
        return res>=(int)1e9 ? -1 : res;
    }
    static boolean checkPowerOf5(String curr)
    {
        if(curr.charAt(0) == '0') return false;
        long p = 1, temp = 0;
        for(int i = curr.length()-1;i>=0;i--){
            temp += p*(curr.charAt(i)-'0');
            p *= 2;
        }
        long n = 1; 
        while(n<=temp){
            if(n == temp) return true;
            n = n*5;
        }
        return false;
    }
}

