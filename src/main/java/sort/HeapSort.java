package sort;

/**
 *  ref: https://www.cnblogs.com/chengxiao/p/6129630.html
 *
 */
public class HeapSort {
    public static int[] sort(int[] arr) {
        creatBigHeap(arr, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            swapBigHeap(arr, i);
            creatBigHeap(arr, i);
        }

        return arr;
    }

    private static void swapBigHeap(int[] arr, int i) {
        ArrayUtil.swap(arr, 0, i);
    }

    public static void creatBigHeap(int[] arr, int length) {
        for (int i = length / 2 - 1; i > -1; i = (i + 1) / 2 - 1) {
            if (((2 * i) + 2) < length) {
                if (arr[(2 * i) + 1] > arr[(2 * i) + 2]) {
                    ArrayUtil.swap(arr, (2 * i) + 1, i);
                } else {
                    ArrayUtil.swap(arr, (2 * i) + 2, i);
                }
            } else if (((2 * i) + 1) < length) {
                if (arr[(2 * i) + 1] > arr[i]){
                    ArrayUtil.swap(arr, (2 * i) + 1, i);
                }
            }
        }
    }
}
