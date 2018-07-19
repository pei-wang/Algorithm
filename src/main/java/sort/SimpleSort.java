package sort;

/**
 * 简单排序
 */
public class SimpleSort {

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                ArrayUtil.swap(arr, i, min);
            }
        }
        return arr;
    }

}
