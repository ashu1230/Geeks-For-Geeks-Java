Given n ranges of the form [p, q] which denotes all the numbers in the range [p, p + 1, p + 2,...q].  Given another integer q denoting the number of queries. The task is to return the kth smallest element for each query (assume k>1) after combining all the ranges.
In case the kth smallest element doesn't exist return -1. 

Example 1:

Input:
n = 2, q = 3
range[] = {{1, 4}, {6, 8}}
queries[] = {2, 6, 10}
Output: 
2 7 -1
Explanation: 
After combining the given ranges, 
the numbers become 1 2 3 4 6 7 8. As here 2nd 
element is 2, so we print 2. As 6th element is 
7, so we print 7 and as 10th element doesn't 
exist, so weprint -1.
Example 2:

Input:
n = 2, q = 2
range[] = {{2, 6}, {5, 7}} 
queries[] = {5, 8}
Output: 
6 -1
Explantion: 
After combining the ranges, we'll take Union of 
range= {2,3,4,5,6,7}, here  5th smallest number 
will be 6 and 8th smallest number does not exists.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthSmallestNum() which takes a n * 2 array denoting the ranges and an array denoting the queries.

Expected Time Complexity: O(nlogn+q*n)
Expected Auxiliary Space: O(q)

Constraints:
1 <= n <= 10^3
1 <= range[i][0] <= range[i][1] <= 2*10^9
1 <= q <= 500
1 <= queries[i] <= 2*10^9


#SOLUTION......
  
  class Solution{
    public:
    vector<int>kthSmallestNum(int n, vector<vector<int>>&range, int q, vector<int>queries){
        sort(range.begin(),range.end()); 
        int end = 0; 
        vector<vector<int>> r;
        // merge the overlapping interval
        while(end < n){ 
            int start = end;
            int maxi = range[end][1];
            while(end < n and maxi >= range[end][0]){
                maxi = max(maxi, range[end][1]);
                end++;
            }
            r.push_back({range[start][0], maxi});
        } 
        
        vector<int> v(r.size());
        int i = 0;
        // prefix sum for number of element present in each interval to further processing
        for(auto x: r){
            int size = x[1] - x[0] + 1;
            v[i] = ((i-1 >= 0)?v[i-1]+size:size);
            i++;
        } 
        
        vector<int> ans;
        for(auto x: queries){
            int ind = lower_bound(v.begin(),v.end(),x) - v.begin(); 
            // if x is greater than the number of element present in the interval
            if(ind >= v.size()){
                ans.push_back(-1);
            }else{
                // count the remaining element and add to the start point of the interval
                int val = ((ind-1 >= 0)?v[ind-1]:0);  
                int rem = abs(x - val);
                int ele = r[ind][0]+rem-1;
                ans.push_back(ele);
            }
        }
        return ans;
    } 
};

