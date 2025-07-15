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
        cyclicSort(arr);

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
