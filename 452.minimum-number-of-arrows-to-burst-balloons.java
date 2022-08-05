import java.util.*;
/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length < 2) return 1;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int endPoint = points[0][1];
        int index = 0;
        int arrow = 1;
        while(index < points.length){
            if(points[index][0] <= endPoint && points[index][1] >= endPoint){
                index++;
            } else {
                arrow++;
                endPoint = points[index][1];
            }
        }
        return arrow;
    }
}
// @lc code=end

