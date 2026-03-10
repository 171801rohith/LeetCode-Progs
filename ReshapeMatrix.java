import java.util.ArrayList;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        ArrayList<Integer> list = new ArrayList<>();

        int[][] result = new int[r][c];

        for (int i = 0; i < mat.length; i++) 
            for (int j = 0; j < mat[0].length; j++) 
                list.add(mat[i][j]);

        int k = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = list.get(k++);
            }
        }
        return result;
    }
}
