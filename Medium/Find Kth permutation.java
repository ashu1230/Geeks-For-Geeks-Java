Given two integers N (1<=N<=9) and K. Find the kth permutation sequence of first N natural numbers. Return the answer in string format.

Example 1:

Input: N = 4, K = 3
Output: 1324
Explanation: 
Permutations of first 4 natural numbers:
1234,1243,1324,1342,1423,1432.....
So the 3rd permutation is 1324. 
Example 2:

Input: N = 3, K = 5
Output: 312
Explanation: 
Permutations of first 3 natural numbers:
123,132,213,231,312,321.
So the 5th permutation is 312. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function kthPermutation() which takes two integers N and K as input parameters and returns a string denoting the kth permutation.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 9
1 <= K <= N!
  
  #SOLUTION.........

  
  class Solution {
    static int [] fact;
    static ArrayList<Integer> digits;
    public static void solve(int n, int k, StringBuilder ans){
        if(n==1){
            ans.append(Integer.toString(digits.get(0)));
            return;
        }
        int ind = k/fact[n-1];
        if(k%(fact[n-1]) == 0) ind--;
        
        ans.append(Integer.toString(digits.get(ind)));
        digits.remove(ind);
        k -= fact[n-1]*ind;
        
        solve(n-1, k, ans);
    }
    public static String kthPermutation(int n,int k) {
        // code here
        fact = new int [n];
        fact[0] = 1;
        for(int i=1; i<n; i++){
            fact[i] = i*fact[i-1];
        }
        digits = new ArrayList<>();
        for(int i=1; i<=n; i++){
            digits.add(i);
        }
        StringBuilder res = new StringBuilder();
        solve(n,k,res);
        return res.toString();
    }
}

