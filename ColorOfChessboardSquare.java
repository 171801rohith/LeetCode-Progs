// 1812. Determine Color of a Chessboard Square
// You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.
// Return true if the square is white, and false if the square is black.
// The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.

// Example 1:
// Input: coordinates = "a1"
// Output: false
// Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.

// Example 2:
// Input: coordinates = "h3"
// Output: true
// Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.

// Example 3:
// Input: coordinates = "c7"
// Output: false
 

public class ColorOfChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        boolean[][] chessboard = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i & 1) == 0) {
                    if ((j & 1) == 0) chessboard[i][j] = false;
                    else chessboard[i][j] = true;
                } else {
                    if ((j & 1) == 0) chessboard[i][j] = true;
                    else chessboard[i][j] = false;
                }
            }
        } 

        return chessboard[coordinates.charAt(1) - '0' - 1][coordinates.charAt(0) - 'a'];
    }
}
