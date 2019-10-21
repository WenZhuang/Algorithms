package main.leetcode_solutions.string;

public class T344_ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        int i = 0, j = s.length - 1;
        while (i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
