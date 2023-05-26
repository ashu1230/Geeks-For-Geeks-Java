
Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power of unique natural numbers. As the total number of ways can be very large, so return the number of ways modulo 10^9 + 7. 

Example 1:

Input: 
n = 10, x = 2
Output: 
1 
Explanation: 
10 = 1^2 + 3^2, Hence total 1 possibility. 
Example 2:

Input: 
n = 100, x = 2
Output: 
3
Explanation: 
100 = 10^2 
6^2 + 8^2 and 1^2 + 3^2 + 4^2 + 5^2 + 7^2 
Hence total 3 possibilities. 
Your Task:  
You don't need to read input or print anything. Complete the function numOfWays() which takes n and x as input parameters and returns the total number of ways n can be expressed as the sum of xth power of unique natural numbers.

Expected Time Complexity: O(n2logn)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 10^3
1 <= x <= 5

  
  class Solution {
	static int helper(int[][] dp, int n, int i, int x) {
		if (Math.pow(i, x) > n)
			return 0;
		if (Math.pow(i, x) == n)
			return 1;
		if (dp[i][n] != -1)
			return dp[i][n];
		int pick = helper(dp, n - (int) Math.pow(i, x), i + 1, x);
		int notPick = helper(dp, n, i + 1, x);
		return dp[i][n] = (pick % 1000000007 + notPick % 1000000007) % 1000000007;
	}

	static int numOfWays(int n, int x) {
		// code here
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		return helper(dp, n, 1, x);
	}
}
