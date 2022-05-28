/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] hold = new int[prices.length];
        hold[prices.length - 1] = 0;
        int[] sold = new int[prices.length];
        sold[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            if(i + 2 > prices.length - 1){
                sold[i] = Math.max( prices[i], sold[i + 1]);
            } else {
                sold[i] = Math.max(hold[i + 2] + prices[i], sold[i + 1]);
            }
            hold[i] = Math.max(sold[i + 1] - prices[i], hold[i + 1]);
        }
        return hold[0];
    }
}
// @lc code=end

