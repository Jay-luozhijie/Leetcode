/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[]dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(Math.max(dp[i - j] * j, (i-j) * j), dp[i]);
            }
        }
        return dp[n];
    }
}
// @lc code=end

