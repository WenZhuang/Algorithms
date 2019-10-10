package main.the_beauty_of_data_structure_and_algorithm.data_structure.string;

public class StringMatching {

    public static int bf(char[] primary, int n, char[] pattern, int m){
        if (n < m){
            return -1;
        }
        for (int i = 0; i <= n - m; i++){
            boolean match = true;
            for (int j = 0; j < m; j++){
                if (primary[i + j] != pattern[j]){
                    match = false;
                    break;
                }
            }
            if (match){
                return i;
            }
        }
        return -1;
    }
}
