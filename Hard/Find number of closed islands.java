
Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.

Example 1:

Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}} 
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands. 
Example 2:

Input:
N = 3, M = 3
mat[][] = {{1, 0, 0},
           {0, 1, 0},
           {0, 0, 1}}
Output: 
1
Explanation:
mat[][] = {{1, 0, 0},
          {0, 1, 0},
          {0, 0, 1}}
There is just a one closed island.
Your task:
You dont need to read input or print anything. Your task is to complete the function closedIslands() which takes two integers N and M, and a 2D binary matrix mat as input parameters and returns the number of closed islands.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)

Constraints:
1 ≤ N,M ≤ 500
  
  
  
  #SOLUTION>...
  class Solution
{
    public int closedIslands(int[][] grid, int n, int m)
    {
        // Code here
     // traversing boundary and converting 0s to 1s
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i*j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        dfs(i,j,n,m,grid);
                    }
                }
            }
        }
        //call DFS in whole grid and count surrounded land
        int count=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                count++;
                        dfs(i,j,n,m,grid);
                    }
                 }
            }
            return count;
    }
    public void dfs(int i,int j,int n,int m,int arr[][]){
        arr[i][j]=0;
        int ax[]={1,-1,0,0};
        int ay[]={0,0,1,-1}; 
        for(int k=0;k<4;k++){
            int nx=i+ax[k];
            int ny=j+ay[k];

            if(isValid(nx,ny,n,m,arr)){
                dfs(nx,ny,n,m,arr);
            }
        }
    }
    boolean isValid(int i,int j,int n,int m,int arr[][]){
        if(i>=0 && i<n && j>=0 && j<m && arr[i][j]==1) 
        return true;

        return false;
    }    
        


}
