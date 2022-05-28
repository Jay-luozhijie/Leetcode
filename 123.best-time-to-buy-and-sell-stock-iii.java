/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][]dp = new int[4][prices.length];
        for(int i = 3; i >= 0; i--){
            for(int j = prices.length - 1; j >= 0; j--){
                if(i % 2 == 0){
                   if(j < prices.length - 1){
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j + 1] - prices[j]);
                   }
                } else {
                    if(j == prices.length - 1){
                        dp[i][j] = prices[j];
                    } else {
                        if(i == 3){
                            dp[i][j] = Math.max(dp[i][j+1], prices[j]);
                        } else {
                            dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j + 1] + prices[j]);
                        }
                    }
                }
               
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

