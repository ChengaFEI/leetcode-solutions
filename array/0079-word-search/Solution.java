import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
  // Backtracking
  // Time Complexity: O(B*3^W)
  // Space Complexity: O(W)
  public boolean exist1(char[][] board, String word) {
    // Data Structure
    Stack<int[]> visited = new Stack<>();
    // Variable Init
    int xSide = board.length, ySide = board[0].length;
    char firstChar = word.charAt(0);
    // Traverse
    for (int i = 0; i < xSide; i++) {
      for (int j = 0; j < ySide; j++) {
        if (board[i][j] == firstChar) {
          int[] pos = new int[] { i, j };
          visited.push(pos);
          if (existRecursively(board, visited, word, pos, 1))
            return true;
          visited.pop();
        }
      }
    }
    return false;
  }
  // Lesson:
  // When directly comparing array, we compare its reference.

  private static boolean existRecursively(char[][] board, Stack<int[]> visited, String word, int[] pos,
      int searchIndex) {
    // Corner Case 1: all characters are traversed
    if (searchIndex >= word.length())
      return true;
    // Corner Case 2: no valid proceeding children
    char searchChar = word.charAt(searchIndex);
    Set<int[]> children = searchChildren(board, visited, pos, searchChar);
    if (children == null || children.size() == 0)
      return false;
    // Traverse (recurse)
    for (int[] childPos : children) {
      visited.push(childPos);
      if (existRecursively(board, visited, word, childPos, searchIndex + 1))
        return true;
      visited.pop();
    }
    return false;
  }

  private static Set<int[]> searchChildren(char[][] board, Stack<int[]> visited, int[] pos, char searchChar) {
    Set<int[]> children = new HashSet<>();
    int[] childUp = { pos[0] - 1, pos[1] };
    int[] childDown = { pos[0] + 1, pos[1] };
    int[] childLeft = { pos[0], pos[1] - 1 };
    int[] childRight = { pos[0], pos[1] + 1 };
    if (isValidChild(board, visited, searchChar, childUp))
      children.add(childUp);
    if (isValidChild(board, visited, searchChar, childDown))
      children.add(childDown);
    if (isValidChild(board, visited, searchChar, childLeft))
      children.add(childLeft);
    if (isValidChild(board, visited, searchChar, childRight))
      children.add(childRight);
    return children;
  }

  private static boolean isValidChild(char[][] board, Stack<int[]> visited, char searchChar, int[] pos) {
    int xSide = board.length, ySide = board[0].length;
    // Check in-bound
    boolean valid = (pos[0] >= 0 && pos[0] < xSide && pos[1] >= 0 && pos[1] < ySide);
    // Check unvisited
    if (valid) {
      for (int[] visitedPos : visited) {
        if (visitedPos[0] == pos[0] && visitedPos[1] == pos[1]) {
          valid = false;
          break;
        }
      }
    }
    // Check character
    if (valid)
      valid = (board[pos[0]][pos[1]] == searchChar);
    return valid;
  }
}
