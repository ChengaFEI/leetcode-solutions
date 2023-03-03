import java.util.Arrays;

public class Solution {
  // Two-Pass Linear Traversal
  // Time Complexity: O(xy)
  // Space Complexity: O(x+y)
  public void setZeroes(int[][] matrix) {
    // Corner Case
    if (matrix == null || matrix.length == 0)
      return;
    // Data Structure
    int xSide = matrix.length, ySide = matrix[0].length;
    boolean[] xToZero = new boolean[xSide], yToZero = new boolean[ySide];
    Arrays.fill(xToZero, false);
    Arrays.fill(yToZero, false);
    // Traverse
    for (int i = 0; i < xSide; i++) {
      for (int j = 0; j < ySide; j++) {
        if (matrix[i][j] == 0) {
          xToZero[i] = true;
          yToZero[j] = true;
        }
      }
    }
    for (int i = 0; i < xSide; i++) {
      for (int j = 0; j < ySide; j++) {
        if (xToZero[i] || yToZero[j])
          matrix[i][j] = 0;
      }
    }
  }
}
