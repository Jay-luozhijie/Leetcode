/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        dp[n] = 1;
        for(int i = n - 1; i >=0 ; i--){
            int one = i + 1 > n ? 0 : dp[i+1];
            int two = i + 2 > n ? 0 : dp[i + 2];
            dp[i] = one + two;
        }
        return dp[0];
    }
}
// @lc code=end

