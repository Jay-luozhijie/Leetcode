import java.util.stream.*;
/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        int target = sum/2;
        int[][]dp = new int[stones.length + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= stones.length; i++){
            for(int j = 0; j <= target; j++){
                if(j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-stones[i]];
                }
            }
        }
        System.out.println(dp[stones.length][target]);
        return (sum - dp[stones.length][target] < 0 ? dp[stones.length] 
    }
}
// @lc code=end

