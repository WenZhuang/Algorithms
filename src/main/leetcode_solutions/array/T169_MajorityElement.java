package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019-10-03 20:40
 */

/**
 * 求众数，此题有多种解法
 * 1)排序，快速排序后取中位数，T(n)=O(n*log(n)), S(n)=1
 * 2)哈希表，用哈希表进行计数，T(n)=O(n), S(n)=O(n)
 * 3)切分法，使用partition函数将数组切分，切分点处于正中间时，切分值即为众数
 *      T(n)=O(n), S(n)=O(1)
 * 4)摩尔投票法，https://en.wikipedia.org/wiki/Boyer-Moore_majority_vote_algorithm
 *      T(n)=O(n), S(n)=O(1)
 * 5)位运算
 * 6)分治法
 * 以下是摩尔投票算法的实现
 */
public class T169_MajorityElement {
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
    //TODO 位运算实现 https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).

    //TODO 切分法实现

    //TODO 摩尔投票算法的扩展 https://leetcode.com/problems/majority-element-ii/
}
