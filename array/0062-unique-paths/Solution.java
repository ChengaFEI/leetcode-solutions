public class Solution {
  // Dynamic Programming
  // Time Complexity: O(mn)
  // Space Complexity: O(mn)
  public int uniquePaths(int m, int n) {
    // Data Structure
    int[][] mem = new int[m][n];
    // Variable Init
    mem[m - 1][n - 1] = 1;
    // Traverse
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i + 1 < m)
          mem[i][j] += mem[i + 1][j];
        if (j + 1 < n)
          mem[i][j] += mem[i][j + 1];
      }
    }
    return mem[0][0];
  }
}
