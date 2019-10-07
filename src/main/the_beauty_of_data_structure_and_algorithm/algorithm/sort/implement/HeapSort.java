package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * @author wenzhuang
 * @date 2019-10-05 19:36
 */
public class HeapSort {
    public static void sort(int[] a){
        int n = a.length - 1;
        //建堆
        buildHeap(a);
        //排序
        while (n > 0) {
            exch(a, 0, n--);
            sink(a, 0, n);
        }
    }

    private static void buildHeap(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--){
            sink(a, i, a.length - 1);
        }
    }

    /**
     * 下沉的实现方式1
     * @param a
     * @param i
     * @param n
     */
    private static void sink(int[] a, int i, int n){
        while (2 * i + 1 <= n){
            //选出左右孩子更大的那个
            int j = 2 * i + 1;
            if (2 * i + 2 <= n && a[2 * i + 2] > a[j]) {
                j++;
            }
            //左右孩子都没有自身大，结束下沉
            if (a[i] >= a[j]){
              break;
            }
            //交换节点
            exch(a, i, j);
            i = j;
        }
    }

    /**
     * 下沉方式2
     * @param a
     * @param i
     * @param n
     */
    private static void sink2(int[] a, int i, int n){
        while (true){
            //选出自身和左右孩子最大的的节点
            int maxPos = i;
            if (2 * i + 1 <= n && a[2 * i + 1] > a[maxPos]) {
                maxPos = 2 * i + 1;
            }
            if (2 * i + 2 <= n && a[2 * i + 2] > a[maxPos]) {
                maxPos = 2 * i + 2;
            }
            //最大节点就是自身，结束下沉
            if (maxPos == i){
                break;
            }
            //交换节点
            exch(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swim(int[] a, int i){
        while (i > 0 && a[(i - 1) / 2] < a[i]){
            exch(a, (i - 1)/ 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
