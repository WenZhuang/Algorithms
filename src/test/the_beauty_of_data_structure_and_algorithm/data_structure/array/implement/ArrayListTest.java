package test.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement;

import main.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement.ArrayList;

/**
 * @author wenzhuang
 * @date 2019-10-02 17:42
 */
public class ArrayListTest {
    public static void main(String[] args){
        arrayListTest();
    }

    private static void arrayListTest(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        arrayList.set(10, 100);
        System.out.println(arrayList);
        arrayList.remove(10);
        System.out.println(arrayList);
        arrayList.add(10, 200);
        System.out.println(arrayList);
    }

}
