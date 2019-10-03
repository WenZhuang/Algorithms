package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:49
 */
public class T457_ClassicalBinarySearch {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
