package sort;
/**
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * */
public class MergeSort {

    public static int[] sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        return temp;
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid;
        int index = 0;
        while (i < mid + 1 && j < right + 1) {
            if (arr[i] > arr[j]) {
                temp[index] = arr[j];
                j++;
            } else {
                temp[index] = arr[i];
                i++;
            }
            index++;
        }

        while (i < mid + 1) {
            temp[index] = arr[i];
            i++;
        }

        while (j < right + 1) {
            temp[index] = arr[j];
            j++;
        }

        index = 0;
        while (left < right){
            arr[left++] = temp[index++];
        }
    }
}
