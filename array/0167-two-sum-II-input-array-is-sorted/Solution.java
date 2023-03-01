public class Solution {
  // Two Pointers + Shrink To Center
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2)
      return null;
    int left = 1, right = numbers.length;
    while (left < right) {
      int sum = numbers[left - 1] + numbers[right - 1];
      if (sum == target)
        return new int[] { left, right };
      if (sum < target)
        left++;
      else
        right--;
    }
    return null;
  }
}
