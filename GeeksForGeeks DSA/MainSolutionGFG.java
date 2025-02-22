import java.util.Arrays;

public class MainSolutionGFG {
    public static void main(String[] args) {
        // 1
        RotateArray rotate = new RotateArray();
        int a[] ={1, 2, 3, 4, 5}, d = 2;
        rotate.rotateArr(a, d);
        System.out.println(Arrays.toString(a));
    }
}