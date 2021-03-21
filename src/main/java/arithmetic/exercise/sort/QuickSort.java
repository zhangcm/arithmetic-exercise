package arithmetic.exercise.sort;

/**
 * 快速排序
 */
public class QuickSort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        this.sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        T base = arr[low];
        int i = low;
        for (int j = high; j > i; j--) {
            if (SortHelper.less(arr[j], base)) {
                for (i = i + 1; i < j; i++) {
                    if (SortHelper.less(base, arr[i])) {
                        SortHelper.swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        SortHelper.swap(arr, low, i);
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }
}
