import java.util.Arrays;
/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // int sum = Arrays.stream(nums).sum();
        // int[][] dp = new int[nums.length + 1][2*sum + 1];
        // int minus;
        // int plus;
        // if(target > sum ||  target < -sum) {
        //     return 0;
        // }
        // dp[0][sum] = 1;
        // for(int i = 1; i <= nums.length; i++){
        //     for(int j = -sum; j <= sum; j++){
        //         minus = j - nums[i - 1] < -sum ? 0 : dp[i - 1][j - nums[i - 1] + sum];
        //         plus = j + nums[i - 1] > sum ? 0 : dp[i - 1][j + nums[i - 1] + sum];
        //         dp[i][j + sum] = minus + plus; 
        //     }
        // }

        // return dp[nums.length][target + sum];
        int sum = Arrays.stream(nums).sum();
        if(target > sum || target < -sum){
            return 0;
        }
        int[]oldDp = new int[2 * sum + 1];
        oldDp[sum] = 1;
        for(int i = 1; i <= nums.length; i++){
            int[]newDp = new int[2 * sum + 1];
            for(int j = -sum; j <= sum; j++){
                int left = j - nums[i - 1] >= -sum ? oldDp[j - nums[i - 1] + sum] : 0;
                int right = j + nums[i - 1] <= sum ? oldDp[j + nums[i - 1] + sum] : 0;
                newDp[j + sum] = left + right;
            }
            oldDp = newDp;
        }
        return oldDp[target + sum];
        // int[][]dp = new int[nums.length][2 * sum + 1];
        // dp[0][0 - nums[0] + sum] += 1;
        // dp[0][0 + nums[0] + sum] += 1;
        // for(int i = 1; i < nums.length; i++){
        //     for(int j = -sum; j <= sum; j++){
        //         int left = j - nums[i] >= -sum ? dp[i - 1][j - nums[i] + sum] : 0;
        //         int right = j + nums[i] <= sum ? dp[i - 1][j + nums[i] + sum] : 0;
        //         dp[i][j + sum] = left + right;
        //     }
        // }
        // return dp[nums.length - 1][target + sum];
    }
}
// @lc code=end

