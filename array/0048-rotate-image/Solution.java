public class Solution {
  // In-place Rotation (every four-cell pairs)
  // Time Complexity: O(M)
  // Space Complexity: O(1)
  public void rotate(int[][] matrix) {
    int side = matrix.length - 1;
    for (int i = 0; i <= (side - 1) / 2; i++) {
      for (int j = i; j < side - i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[side - j][i];
        matrix[side - j][i] = matrix[side - i][side - j];
        matrix[side - i][side - j] = matrix[j][side - i];
        matrix[j][side - i] = tmp;
      }
    }
  }
  // Lesson:
  // Four cells in a rotation group has connections in their indices.
}
