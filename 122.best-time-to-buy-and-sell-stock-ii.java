/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int start = 0;
        int end = 0;
        while(end < prices.length && start < prices.length){
            if(prices[end] < prices[start]){
                start = end;
            } else {
                result += prices[end] - prices[start];
                start = end;
                end++;
            }
        }
        return result;
    }
}
// @lc code=end

