You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-nagative numbers.(Maintain the order of all -ve and non-negative numbers as given in the original array).
Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 
Example 1:

Input:
N = 4
Arr[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 1, 0.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array Arr[] and its size N as inputs and returns the array after rearranging with spaces between the elements of the array.
Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(Log(N))

Constraints:
1 ≤ N ≤ 105
-109 ≤ Elements of array ≤ 10^9



#SOLUTION.....
  
//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        int x=0;
        for(int i=0;i<n;i++)
            if(a[i] < 0){
                int temp = a[i];
                int y = i;
                while(y > x)
                {
                    a[y] = a[y-1];
                    y--;
                }
                a[x++] = temp;
            }
    }
}
