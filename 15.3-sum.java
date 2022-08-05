import java.util.*;
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    // public HashSet<ArrayList<Integer>> hs = new HashSet<>();
    // public void findTwoSum(int firstEle, ArrayList<Integer> arrayList){
    //     int target = -firstEle;
    //     HashSet<Integer> tempHs = new HashSet<>();
    //     for(int i = 0; i < arrayList.size(); i++){
    //         if(tempHs.contains(target - arrayList.get(i))){
    //             ArrayList<Integer> arr = new ArrayList<>();
    //             arr.add(firstEle);
    //             arr.add(target - arrayList.get(i));
    //             arr.add(arrayList.get(i));
    //             arr.sort((a,b)-> a - b);
    //             hs.add(arr);
    //         } else {
    //             tempHs.add(arrayList.get(i));
    //         }
    //     }
    //     return;
    // }
    List<List<Integer>> al = new ArrayList<>();
    public void findTwoSum(int first, int left, int right, int[] array){
        while(left < right){
            if(array[left] + array[right] < -first){
                left++;
            } else if(array[left] + array[right] > -first){
                right--;
            } else {
                al.add(new ArrayList(Arrays.asList(first, array[left], array[right])));
                left++;
                while(array[left] == array[left - 1] && left < right){
                    left++;
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;){
            findTwoSum(nums[i], i + 1, nums.length - 1, nums);
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return al;
    //    for(int i = 0; i < nums.length; i++){
    //         ArrayList<Integer> al = new ArrayList<>();
    //         for(int e:nums){
    //             al.add(e);
    //         }
    //         al.remove(i);
    //         findTwoSum(nums[i], al);
    //    }
    //    return new ArrayList<>(hs);
    }
}
// @lc code=end

