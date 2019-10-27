package main.leetcode_solutions.greedy;

public class T1221_BalancedStrings {
    public int balancedStringSplit(String s) {
        int res = 0;
        int countL = 0, countR = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'R'){
                countR++;
            } else {
                countL++;
            }
            if (countL == countR){
                res++;
                countL = 0;
                countR = 0;
            }
        }
        return res;
    }
}
