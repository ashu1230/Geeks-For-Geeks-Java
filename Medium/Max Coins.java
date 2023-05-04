You are given a 2D integer array ranges whose length is n where ranges[i]=[starti, end,coinsi] means all integers from starti to endi inclusive starti and endi are present and we get coinsi amount of coins when we select this ith range. You can select at most two intervals so as to collect maximum coins but if you select two ranges then those two ranges should not intersect or overlap but can touch each other.

Note: You can select at max 2 ranges and they should not intersect with each other but they can touch themselves.

Example 1:

Input :
n=3
ranges={{1,3,4},{2,3,5},{3,4,2}}
Output: 7
Explanation:
We can see that we can take 2nd and 
3rd ranges as they are not intersecting
(only touching) we get maximum Coins by 
taking these ranges(5+2=7).
Example 2:

Input :
n=5
ranges={{1,3,4},{2,3,5},{3,4,2},{5,8,9},{2,8,10}}
Output: 14
Explanation:
We can see that we can take 2nd and 
4th ranges as they are not intersecting 
we get maximum Coins(5+9=14) by taking 
these ranges.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer n(length of ranges), integer 2D integer array ranges, and you have to return the maximum number of coins you got after selecting at most two ranges that are not intersecting.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(n)

Constraints:
1<=n<=10^5
0<=ranges[i][0]<=ranges[i][1]<=10^9
0<=ranges[i][2](coins)<=10^6
The sum of n over all test cases won't exceed 10^6
  
  
  #SOLUTION---
  
  //User function Template for Java
class Solution{
    public static int maxCoins(int n,int arr[][])
    {
        Arrays.sort(arr, (a, b)->a[1]==b[1]? a[0]-b[0]:a[1]-b[1]);
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        for(int p[] : arr){
            int key = tm.floorKey(p[0]);
            int prev = tm.get(key);
                // System.out.println(key+" "+prev+" ----> "+p[0]+" "+p[1]+" "+p[2]);
                max = Math.max(prev+p[2], max);
                int prevEndMax = tm.get(tm.floorKey(p[1]));
                
                        tm.put(p[1], Math.max(prevEndMax,p[2]));
                    
            
        }
        return max;
    }
}
