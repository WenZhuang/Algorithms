package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019-10-03 20:40
 */

/**
 * 求众数，此题有多种解法
 * 1)摩尔投票法，https://en.wikipedia.org/wiki/Boyer-Moore_majority_vote_algorithm
 *      T(n)=O(n), S(n)=O(1)
 * 2)分治法 T(n)=O(n*lg(n)),S(n)=O(lg(n))
 */
public class T169_MajorityElement {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++){
            if (count == 0){
                major = nums[i];
                count++;
            } else if (major == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int low, int high){
        if (low == high){
            return nums[low];
        }
        int mid = ((high - low) >> 1) + low;
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid + 1, high);
        if (left == right){
            return left;
        }
        int countLeft = count(nums, left, low, high);
        int countRight = count(nums, right, low, high);
        return countLeft > countRight ? left : right;
    }

    private int count(int[] nums, int num, int low, int high){
        int count = 0;
        for (int i = low; i <= high; i++){
            if (nums[i] == num){
                count++;
            }
        }
        return count;
    }

    //TODO 摩尔投票算法的扩展 https://leetcode.com/problems/majority-element-ii/
}
