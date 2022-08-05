/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // int result = 0;
        // int start = 0;
        // int end = 0;
        // while(end < prices.length && start < prices.length){
        //     if(prices[end] < prices[start]){
        //         start = end;
        //     } else {
        //         result += prices[end] - prices[start];
        //         start = end;
        //         end++;
        //     }
        // }
        // return result;
        int left = 0;
        int right = 1;
        int sum = 0;
        while(left < prices.length && right < prices.length){
            if(prices[right] > prices[left]){
                sum += prices[right] - prices[left];
            } 
            right++;
            left++;
        }
        return sum;
    }
}
// @lc code=end

