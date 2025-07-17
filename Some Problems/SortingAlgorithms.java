import java.util.Arrays;

public class SortingAlgorithms {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }

            if (minIndex != i)
                swap(arr, i, minIndex);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }

        }
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, k = low, j = mid + 1;
        int[] buf = new int[arr.length];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                buf[k++] = arr[i++];
            else
                buf[k++] = arr[j++];
        }
        while (i <= mid)
            buf[k++] = arr[i++];
        while (j <= high)
            buf[k++] = arr[j++];

        for (int l = low; l <= high; l++) {
            arr[l] = buf[l];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        // 1
        // bubbleSort(arr);

        // 2
        // selectionSort(arr);

        // 3
        // insertionSort(arr);

        // 4
        // cyclicSort(arr);

        // 5
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
