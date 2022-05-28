/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int start,end;
        start = 0;
        end = 1;
        int max = 0;
        while(start < prices.length && end < prices.length){
            if(prices[end] - prices[start] > max){
                max = prices[end] - prices[start];
            }
            if(prices[start] > prices[end]){
                start = end;
            }
            end++;
        }
        return max;
    }
}
// @lc code=end

