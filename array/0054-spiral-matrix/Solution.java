import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private static final int VISITED = 101;
  private static final int[] RIGHT = new int[] { 0, 1 };
  private static final int[] DOWN = new int[] { 1, 0 };
  private static final int[] LEFT = new int[] { 0, -1 };
  private static final int[] UP = new int[] { -1, 0 };
  private static final Map<int[], int[]> NEXT_DIRECTION = new HashMap<>() {
    {
      put(RIGHT, DOWN);
      put(DOWN, LEFT);
      put(LEFT, UP);
      put(UP, RIGHT);
    }
  };

  // M4 (Move-Measure-Memorize Method)
  // Time Complexity: O(MN)
  // Space Complexity: O(1)
  public List<Integer> spiralOrder(int[][] matrix) {
    // Step 0: Create Data Structure
    List<Integer> result = new ArrayList<>();
    // Step 1: Initialize Variables
    int xBound = matrix.length, yBound = matrix[0].length;
    int chDirectionNum = 0, row = 0, col = 0;
    int[] dir = RIGHT;
    result.add(matrix[row][col]);
    matrix[0][0] = VISITED;
    // Step 2: Iterate
    while (chDirectionNum < 2) {
      while (row + dir[0] >= 0 && row + dir[0] < xBound &&
          col + dir[1] >= 0 && col + dir[1] < yBound &&
          matrix[row + dir[0]][col + dir[1]] != VISITED) {
        row += dir[0];
        col += dir[1];
        result.add(matrix[row][col]);
        matrix[row][col] = VISITED;
        chDirectionNum = 0;
      }
      dir = NEXT_DIRECTION.get(dir);
      chDirectionNum++;
    }
    return result;
  }
  // Lesson 1:
  // When the input data structure is mutable (the object itself is mutable and
  // the structure will not be reused) and it is shown in return results, we can
  // place VISITED flag in-place.
  // Lesson 2:
  // We can use x, y coordinates' increments to represent directions in a matrix.
}
