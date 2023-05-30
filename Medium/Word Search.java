
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0
Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input parameter and returns boolean value true if word can be found otherwise returns false.

Expected Time Complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
Expected Space Compelxity: O(L), L is length of word.

Constraints:
1 ≤ N, M ≤ 100
1 ≤ L ≤ N*M


#SOLUTION....
  
class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col] && isWordFound(board, word, row, col, visited))
                    return true;
            }
        }
        return false;
    }
    boolean isWordFound(char[][] board, String word, int row, int col, boolean[][] visited) {
        if (word.length() == 0)return true;
        if (row < 0 || col < 0 || row == visited.length || col == visited[0].length || visited[row][col]
                || word.charAt(0) != board[row][col])
            return false;
        visited[row][col] = true;
        word = word.substring(1);
        boolean up = isWordFound(board, word, row, col + 1, visited);
        boolean down = isWordFound(board, word, row, col - 1, visited);
        boolean right = isWordFound(board, word, row + 1, col, visited);
        boolean left = isWordFound(board, word, row - 1, col, visited);
        visited[row][col] = false;
        return (up || down || right || left);
    }
}

