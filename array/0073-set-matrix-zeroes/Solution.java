import java.util.Arrays;

public class Solution {
  // Two-Pass Linear Traversal
  // Time Complexity: O(xy)
  // Space Complexity: O(x+y)
  public void setZeroes1(int[][] matrix) {
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

  // In-place Replacement
  // Time Complexity: O(mn)
  // Space Complexity: O(1)
  public void setZeroes2(int[][] matrix) {
    // Corner Case
    if (matrix == null || matrix.length == 0)
      return;
    // Variable Init
    int xSide = matrix.length, ySide = matrix[0].length;
    boolean colToZero = false;
    // Traverse
    for (int i = 0; i < xSide; i++) {
      if (matrix[i][0] == 0)
        colToZero = true;
      for (int j = 1; j < ySide; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < xSide; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < ySide; j++)
          matrix[i][j] = 0;
      }
    }
    for (int j = 1; j < ySide; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < xSide; i++)
          matrix[i][j] = 0;
      }
    }
    if (matrix[0][0] == 0)
      Arrays.fill(matrix[0], 0);
    if (colToZero) {
      for (int i = 0; i < xSide; i++)
        matrix[i][0] = 0;
    }
  }
}
