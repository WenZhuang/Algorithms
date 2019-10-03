package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:50
 */
public class T463_SortIntegers {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        for(int i = 0; i < A.length; i++){
            for(int j = i; j > 0; j--){
                if(A[j] < A[j - 1]){
                    int t = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = t;
                }
            }
        }
    }
}
