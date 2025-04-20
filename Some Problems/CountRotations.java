public class CountRotations {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int count = FindPivot.pivotIfDuplicates(arr) + 1;
        System.out.println("Rotations Count: " + count);
    }
}
