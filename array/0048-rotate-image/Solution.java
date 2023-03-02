public class Solution {
  // In-place Rotation (every four-cell pairs)
  // Time Complexity: O(M)
  // Space Complexity: O(1)
  public void rotate1(int[][] matrix) {
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

  // Transpose + Reverse (horizontally) = Rotate (clockwise 90 degree)
  // Time Complexity: O(M)
  // Space Complexity: O(1)
  public void rotate2(int[][] matrix) {
    transpose(matrix);
    reverse(matrix);
  }
  // Lesson:
  // Three ways to transform a matrix
  // -- mathematical way: linear algebra
  // -- trace cells in a transformation group using patterns of their indices
  // -- divide transformation into basic and easy-to-implement types (mirror,
  // translation)

  private static void transpose(int[][] matrix) {
    int side = matrix.length;
    for (int i = 0; i < side - 1; i++) {
      for (int j = i + 1; j < side; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

  private static void reverse(int[][] matrix) {
    int side = matrix.length;
    for (int i = 0; i < side; i++) {
      for (int j = 0; j < side / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][side - j - 1];
        matrix[i][side - j - 1] = tmp;
      }
    }
  }
}
