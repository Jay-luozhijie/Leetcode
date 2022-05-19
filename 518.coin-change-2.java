/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        int up;
        int left;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++){
                if(j == 0){
                    dp[i][j] = 1;
                } else {
                    up = i - 1 >= 0? dp[i - 1][j] : 0;
                    left = j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}
// @lc code=end