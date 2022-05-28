/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
<<<<<<< HEAD
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
=======
        
>>>>>>> 88bcb35e9f47686d3ec8a23538665cd62ff8c8d7
    }
}
// @lc code=end

