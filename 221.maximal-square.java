/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int below,right,diagonal;
        dp[row - 1][col - 1] = 0;
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >=0; j--){
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if(i == row - 1) {below = 0;}
                    else {below = dp[i + 1][j];}
                    if(j == col - 1) {right = 0;}
                    else {right = dp[i][j + 1];}
                    if(i < row - 1 && j < col - 1) {diagonal = dp[i + 1][j + 1];}
                    else {diagonal = 0;}
                    dp[i][j] = (int)Math.pow(1 + (int)Math.sqrt(Math.min(Math.min(below,right), diagonal)),2);
                    max = Math.max(dp[i][j], max);
                }
                System.out.println(dp[i][j]);
            }
            System.out.println('\n');
        }

        return max;
    }
}
// @lc code=end

