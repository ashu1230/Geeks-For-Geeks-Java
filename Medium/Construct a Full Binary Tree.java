Given two arrays that represent Preorder traversals of a Full binary tree preOrder[] and its mirror tree preOrderMirror[], your task is to complete the function constructBinaryTree(), that constructs the full binary tree using these two Preorder traversals.

Note: It is not possible to construct a general binary tree using these two traversal. But it is possible to create a full binary tree using the above traversals without any ambiguity.

Example 1:

Input :
preOrder[] = {0,1,2}
preOrderMirror[] = {0,2,1} 

Output :
                0
              /   \
             1     2
Explanation :
Tree in the output and it's mirror tree matches the preOrder and preOrderMirror.
Example 2:

Input :  
preOrder[] = {1,2,4,5,3,6,7}
preOrderMirror[] = {1,3,7,6,2,5,4}

Output :          
                 1
               /    \
              2      3
            /   \   /  \
           4     5 6    7
Explanation :
Tree in the output and it's mirror tree matches the preOrder and preOrderMirror.
Your Task:

You don't need to read, input, or print anything. Your task is to complete the function constructBTree, The function takes three arguments as input, first the array that represent Preorder traversals of a Full binary tree preOrder[], second the array that represents the preorder traversal of its mirror tree preOrderMirror[] and last the size of both the array,and returns root of the full binary tree.

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(N), where N indicates number of nodes.

Constraints:
1 <= Number of Nodes <= 10^3


#SOLUTION....
  class Solution {
	public int find(int a[], int si, int ei, int key) {
		for (int i = si; i <= ei; i++) {
			if (a[i] == key)
				return i;
		}
		return -1;
	}

	public Node construct(int pre[], int preM[], int si, int ei, int mSI, int mEI) {
		if (si > ei)
			return null;
		Node root = new Node(pre[si]);
		if (si == ei)
			return root;
		int x = find(pre, si + 1, ei, preM[mSI + 1]);
		root.left = construct(pre, preM, si + 1, x - 1, mSI + (ei - x + 1) + 1, mEI);
		root.right = construct(pre, preM, x, ei, mSI + 1, mSI + (ei - x + 1));
		return root;
	}

	public Node constructBTree(int pre[], int preM[], int size) {
		// your code here
		return construct(pre, preM, 0, size - 1, 0, size - 1);
	}

}


