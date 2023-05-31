Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum frequency.

Example 1:

Input: 
5
2 2 5 50 1
Output:
50
Explanation :
All elements are having frequency 1 except 2.
50 is the maximum element with minimum frequency.
Example 2:

Input:
4
3 3 5 5
Output:
5
Explanation:
Both 3 and 5 have the same frequency, so 5 should be returned.
User Task:
Your task is to complete the provided function LargButMinFreq(A, n) which accepts array A and n. Hence you have to return the largest element with minimum frequency.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^6

#SOLUTION....

class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int a[], int n) {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        int min=Integer.MAX_VALUE,ans=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()<min) {
                min=m.getValue();
                ans=m.getKey();
            }
            if(m.getValue()==min && m.getKey()>ans){
                ans=m.getKey();
            }
        }
        return ans;
    }
}
 

