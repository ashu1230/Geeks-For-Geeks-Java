Given an array Arr of N positive integers and an integer K, find K largest elements from the array.  The output elements should be printed in decreasing order.

Example 1:

Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.
Example 2:

Input:
N = 7, K = 3
Arr[] = {1, 23, 12, 9, 30, 2, 50}
Output: 50 30 23
Explanation: 3 Largest element in the
array are 50, 30 and 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function kLargest() which takes the array of integers arr, n and k as parameters and returns an array of integers denoting the answer. The array should be in decreasing order.

Expected Time Complexity: O(N + KlogK)
Expected Auxiliary Space: O(K+(N-K)*logK)

Constraints:
1 ≤ K ≤ N ≤ 10^5
1 ≤ Arr[i] ≤ 10^6


#SOLUTION....
  class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        int[] ans = new int[k];
       int key=0;
       
        for(int i=n-1; i>n-1-k ;i--){
            ans[key++]=arr[i];
        }
        return ans;
    }
}

