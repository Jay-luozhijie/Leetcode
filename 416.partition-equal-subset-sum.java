import java.util.stream.*;
import java.util.HashSet;
/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        System.out.println(target);
        boolean[]oldDp = new boolean[target + 1];
        boolean[]newDp = new boolean[target + 1];
        for(int j = 0; j < nums.length; j++){
            if(j == nums[0] || j == 0){
                oldDp[j] = true;
            }
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < target + 1; j++){
                newDp[j] = j - nums[i] >= 0 ? oldDp[j] || oldDp[j - nums[i]] : oldDp[j];
                
            }
            for(int j = 0; j < target + 1; j++){
                oldDp[j] = newDp[j];
            }
        }
        return oldDp[target];
        // HashSet<Integer> hs = new HashSet<>();
        // HashSet<Integer> tempHs = new HashSet<>();
        // int sum = IntStream.of(nums).sum();
        // hs.add(0);
        // for(int i = nums.length - 1; i >= 0; i--){
        //     for(Integer e : hs) {
        //         tempHs.add(nums[i] + e);
        //     }
        //     for(Integer e : tempHs){
        //         hs.add(e);
        //     }
        //     tempHs.clear();
        // }
        // return sum % 2 == 0 && hs.contains(sum/2);
    }
}
// @lc code=end

