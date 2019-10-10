package test.the_beauty_of_data_structure_and_algorithm.data_structure.string;

import main.the_beauty_of_data_structure_and_algorithm.data_structure.string.StringMatching;

public class StringMatchingTest {
    public static void main(String[] args){
        String a = "abcde";
        String b = "abd";
        int index = StringMatching.bf(a.toCharArray(), a.length(), b.toCharArray(), b.length());
        System.out.println(index);
    }
}
