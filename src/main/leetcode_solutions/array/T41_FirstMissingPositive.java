package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019-10-03 19:57
 */

/**
 * 思路：将数字i放在下标为i-1的位置上，调整完毕后，第一个"不在其位"的数字即为解
 * 关键点：注意有重复数字的情况，当要交换的两个数字相等则不能再交换，否则容易造成死循环
 */
public class T41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1){
                if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]){
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
