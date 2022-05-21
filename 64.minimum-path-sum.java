/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int i = grid.length - 1; i >= 0; i--){
            for(int j = grid[0].length - 1; j >= 0; j--){
                if(i == grid.length - 1 && j == grid[0].length - 1){
                    dp[i][j] = grid[i][j];
                } else {
                    int down = i + 1 >= grid.length? Integer.MAX_VALUE : dp[i+1][j];
                    int right = j + 1 >= grid[0].length ? Integer.MAX_VALUE : dp[i][j+1];
                    dp[i][j] = grid[i][j] + Math.min(down, right);
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

