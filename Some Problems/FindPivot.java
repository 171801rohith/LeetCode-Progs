public class FindPivot {
    // Alternate for Finding the maximum number in a sorted rotated array.
    // { 4, 5, 6, 7, 1, 2 }

    public static int pivot(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > low && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (arr[mid] <= arr[low])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int pivotIfDuplicates(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > low && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {

                if (arr[low] > arr[low + 1])
                    return low;
                low++;

                if (arr[high] < arr[high - 1])
                    return high;
                high--;
            } else if (arr[low] < arr[mid] || (arr[low] == arr[mid] && arr[mid] > arr[high]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

}
