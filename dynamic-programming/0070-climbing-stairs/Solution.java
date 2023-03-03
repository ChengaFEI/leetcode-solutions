public class Solution {
  // Dynamic Programming
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int climbStairs(int n) {
    // Corner Case
    if (n < 3)
      return n;
    // Data Structure
    int[] mem = new int[n];
    // Variable Init
    mem[n - 1] = 1;
    mem[n - 2] = 2;
    // Traverse
    for (int i = n - 3; i >= 0; i--)
      mem[i] = mem[i + 1] + mem[i + 2];
    return mem[0];
  }
}
