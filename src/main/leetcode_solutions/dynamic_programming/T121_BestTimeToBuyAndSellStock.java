package main.leetcode_solutions.dynamic_programming;

/**
 * 买卖股票问题1：单次交易
 */
public class T121_BestTimeToBuyAndSellStock {
    /**
     * 最符合人脑思维的解法：每次和前面最小的股价相减，取利润最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int maxPro = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            maxPro = Math.max(maxPro, prices[i] - min);
        }
        return maxPro;
    }

    /**
     * 解法2：Kadane's Algorithm
     * 转换为最大子数组和问题，数组的元素为a[i]=prices[i+1]-prices[i]
     * 这种解法其实难以想到，仅供参考
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int maxPro = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            maxPro = Math.max(maxPro, prices[i] - min);
        }
        return maxPro;
    }

}
