/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // int[][]dp = new int[coins.length + 1][amount + 1];
        // dp[0][0] = 0;
        // for(int j = 1; j < amount + 1; j++){
        //     dp[0][j] = amount + 1;
        // }
        // for(int i = 1; i < coins.length + 1; i++){
        //     for(int j = 1; j < amount + 1; j++){
        //         if(j - coins[i - 1] < 0){
        //             dp[i][j] = dp[i-1][j];
        //         } else {
        //             if(dp[i-1][j] < 1 + dp[i][j-coins[i - 1]]){
        //                 dp[i][j] = dp[i-1][j];
        //             } else {
        //                 dp[i][j] = 1 + dp[i][j-coins[i - 1]];
        //             }
        //         }
        //     }
        // }
        // return dp[coins.length][amount] <= amount ? dp[coins.length][amount] : -1;
        int[] dp = new int[amount + 1];
        int min;
        for(int i = 1; i < amount + 1; i++){
            dp[i] = amount + 1;
        }
        for(int i = 1; i < amount + 1; i++){
            for(int j = 0; j < coins.length; j++){
                if(i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

