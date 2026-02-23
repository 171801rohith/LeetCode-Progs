import java.util.ArrayList;

public class Recursion2 {
    public static boolean isSorted(int[] nums, int i) {
        if (i == nums.length - 1) return true;
        return nums[i] < nums[i + 1] && isSorted(nums, i + 1);
    }

    public static boolean linearSearch(int[] nums, int target, int i) {
        if (nums[i] == target) return true;
        if (i == nums.length - 1) return false;
        return linearSearch(nums, target, i + 1);
    }

    static ArrayList<Integer> indices = new ArrayList<>();

    public static void findAllOccurence(int nums[], int target, int i) {
        if (i == nums.length) return;
        if (nums[i] == target) indices.add(i);
        findAllOccurence(nums, target, i + 1);
    }

    public static ArrayList<Integer> findAllOccurence(int nums[], int target, int i, ArrayList<Integer> list) {
        if (i == nums.length) return list;
        if (nums[i] == target) indices.add(i);
        return findAllOccurence(nums, target, i + 1, list);

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4};
        // System.out.println("Result: " + isSorted(nums, 0));

        // System.out.println("Result: " + linearSearch(nums, 3, 0));
        
        // findAllOccurence(nums, 3, 0);
        // System.out.println("Result: " + indices);

        System.out.println("Result: " + findAllOccurence(nums, 3, 0, indices));
    }
}
