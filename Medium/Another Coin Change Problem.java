Given three integers n, k, target, and an array of coins of size n. Find if it is possible to make a change of target cents by using an infinite supply of each coin but the total number of coins used must be exactly equal to k.

Example 1:

Input:
n = 5, k = 3, target = 11
coins = {1, 10, 5, 8, 6}

Output: 
1

Explanation: 
2 coins of 5 and 1 coins of 1 can be used 
to make change of 11 i.e. 11 => 5+5+1.
Example 2:

Input:
n = 3, k = 5, target = 25
coins = {7, 2, 4}

Output:
1

Explanation:
3 coins 7, 2 coins of 2 can be used to
make change of 25 i.e. 25 => 7+7+7+2+2.
Your Task:
This is a function problem. You only need to complete the function makeChanges() that 3 integers n, k, target, and an array coins as parameters and return True or False.

Expected Time Complexity: O(n*k*target)
Expected Space Complexity: O(k*target)

Constraints:
1 <= n, k, coins[i] <= 100
1 <= target <= 1000
  
  
  #SOLUTION.....
  class Solution {
        public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        boolean[][] dp = new boolean[K+1][target+1];
        for(int j = 0; j <= K; j++) {
            for(int k = 0; k <= target; k++) {
                dp[j][k] = false;
            }
        }
        dp[0][0] = true;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                for(int k = coins[i-1]; k <= target; k++) {
                    dp[j][k] |= dp[j-1][k-coins[i-1]];
                }
            }
        }
        return dp[K][target];
    }
}
