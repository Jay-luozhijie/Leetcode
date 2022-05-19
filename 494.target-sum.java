import java.util.Arrays;
/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length + 1][2*sum + 1];
        int minus;
        int plus;
        if(target > sum ||  target < -sum) {
            return 0;
        }
        dp[0][sum] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = -sum; j <= sum; j++){
                minus = j - nums[i - 1] < -sum ? 0 : dp[i - 1][j - nums[i - 1] + sum];
                plus = j + nums[i - 1] > sum ? 0 : dp[i - 1][j + nums[i - 1] + sum];
                dp[i][j + sum] = minus + plus; 
            }
        }

        return dp[nums.length][target + sum];
    }
}
// @lc code=end

