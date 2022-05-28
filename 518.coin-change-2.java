/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length + 1][amount + 1];
        // int up;
        // int left;
        // dp[0][0] = 1;
        // for(int i = 1; i <= coins.length; i++) {
        //     for(int j = 0; j <= amount; j++){
        //         if(j == 0){
        //             dp[i][j] = 1;
        //         } else {
        //             up = dp[i-1][j];
        //             left = j - coins[i - 1] >= 0 ? dp[i][j - coins[i - 1]] : 0;
        //             dp[i][j] = up + left;
        //         }
        //     }
        // }
        // return dp[coins.length][amount];
        //1D method
        int[] oldDp = new int[amount + 1];
        oldDp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            int[] newDp = new int[amount + 1];
            newDp[0] = 1;
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0){
                    newDp[j] = oldDp[j] + newDp[j - coins[i]];
                } else {
                    newDp[j] = oldDp[j];
                }
            }
            oldDp = newDp;
        }
        return oldDp[amount];
    }
}
// @lc code=end