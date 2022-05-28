/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k*2][prices.length];
        for(int i = k*2 - 1; i >= 0; i--){
            for(int j = prices.length - 1; j >= 0; j--){
                if(i%2 == 0){
                    if(j == prices.length - 1){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j+1] - prices[j], dp[i][j+1]);
                    }
                } else {
                    if(j == prices.length - 1){
                        dp[i][j] = prices[j];
                    } else if(i == k*2 - 1){
                        dp[i][j] = Math.max(dp[i][j + 1], prices[j]);
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j+1] + prices[j],dp[i][j+1]);
                    }
                }
            }
        }
        return dp.length > 0 && dp[0].length > 0 ? dp[0][0] : 0;
    }
}
// @lc code=end

