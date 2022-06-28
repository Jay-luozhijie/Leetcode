/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][]dp = new int[row][col];
        dp[row - 1][col - 1] = obstacleGrid[row-1][col-1] == 1 ? 0 : 1;
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(!(i == row - 1 && j == col - 1)){
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    } else {
                        if(i == row - 1){
                            dp[i][j] = dp[i][j + 1];
                        } else if(j == col - 1){
                            dp[i][j] = dp[i + 1][j];
                        } else {
                            dp[i][j] = dp[i+1][j] + dp[i][j+1];
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

