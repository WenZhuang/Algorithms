package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:41
 */
public class T14_FirstPositionOfTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target){
                if(mid > 0 && nums[mid - 1] == target){
                    high = mid - 1;
                }else{
                    return mid;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
