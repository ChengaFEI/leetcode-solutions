public class Solution {
  // Optimized Brute Force
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public int maxSubArray1(int[] nums) {
    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int val = 0;
      for (int j = i; j < nums.length; j++) {
        val += nums[j];
        maxVal = Math.max(maxVal, val);
      }
    }
    return maxVal;
  }
  // Lesson:
  // Use one-pass iteration in inner nested traversal.
}