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

  // Dynamic Programming
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int maxSubArray2(int[] nums) {
    int maxVal = nums[0], curVal = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      curVal = Math.max(num, num + curVal);
      maxVal = Math.max(curVal, maxVal);
    }
    return maxVal;
  }
  // Lesson:
  // Move-Measure-Memorize Methods (M4) - As pointers move along the list,
  // memorize the result of each iteration and measure the information. Each
  // iteration afterwards will be based on the measurement of a previous
  // iteration.
}