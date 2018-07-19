package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static int[] sort(int[] arr) {
        int shellFactor = arr.length / 2;
        while (true) {
            if (shellFactor < 1) {
                break;
            }
            for (int i = shellFactor; i < arr.length; i = i + shellFactor) {
                for (int j = i; j > 0; j = j - shellFactor) {
                    if (arr[j] < arr[j - shellFactor]) {
                        ArrayUtil.swap(arr, j, j - shellFactor);
                    }

                }
            }
            shellFactor = shellFactor / 2;
        }
        return arr;
    }
}
