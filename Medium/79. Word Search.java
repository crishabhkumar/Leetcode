/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

//Solution

class Solution {
    public boolean exist(char[][] board, String word) {
        int M = board.length, N = board[0].length;
        
        // If any character in word is missing in matrix we can confirm that its not possible
		// This reduces running time from 97ms to 22 ms
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                set.add(board[i][j]);
            }
        }
        for(char ch: word.toCharArray())
            if(!set.contains(ch)) return false;
        
        
        // Do backtracking
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if(pos == word.length()) {
            return true;
        }
        
        int M = board.length, N = board[0].length;
        if(i < 0 || i >= M || j < 0 || j >= N || board[i][j] == '*' || board[i][j] != word.charAt(pos))
            return false;
    
        char prevValue = board[i][j];
        board[i][j] = '*';
        
        boolean result =  dfs(board, word, i + 1, j, pos + 1) ||
                            dfs(board, word, i - 1, j, pos + 1) ||
                                dfs(board, word, i, j + 1, pos + 1) ||
                                    dfs(board, word, i, j - 1, pos + 1);
        
        board[i][j] = prevValue;
        return result;
    }
}
