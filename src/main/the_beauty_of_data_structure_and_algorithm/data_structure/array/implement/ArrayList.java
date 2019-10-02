package main.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement;

/**
 * 数组：支持新增、修改、删除、插入
 * @author wenzhuang
 * @date 2019-10-02 16:31
 */
public class ArrayList {
    private int[] array;
    private int size = 10;
    private int count = 0;

    public ArrayList(){
        array = new int[size];
    }

    public ArrayList(int size){
        this.size = size;
        array = new int[size];
    }

    public void add(int num){
        if (count + 1 > size) {
            resize();
        }
        array[count++] = num;
    }

    public void set(int index, int num){
        if (index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = num;
    }

    public int get(int i){
        if (i >= count){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[i];
    }

    public void remove(int index){
        if (index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < count - 1; i++){
            array[i] = array[i + 1];
        }
        count--;
    }

    public void add(int index, int num){
        if (count + 1 > size){
            resize();
        }
        for (int i = count; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = num;
    }

    private void resize(){
        int[] nArray = new int[2 * size];
        for (int i = 0; i < size; i++){
            nArray[i] = array[i];
        }
        size *= 2;
        array = nArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++){
            stringBuilder.append(array[i]).append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
