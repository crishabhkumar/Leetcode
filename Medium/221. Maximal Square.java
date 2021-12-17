/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
*/



//Solution:
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        
        // matrix to  keep track the size of a square which its bottom right corner is i,j
        int S[][] = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 || j == 0) S[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '0') S[i][j] = 0;
                else {
                    S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                }
                
                //replace the largest square if necessary
                if (max < S[i][j]) max = S[i][j];
            }
        }
        return max*max;
    }
}
