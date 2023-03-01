public class Solution {
  // Two Pointers + Shrink To Center
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int maxArea(int[] height) {
    int maxArea = 0, left = 0, right = height.length - 1;
    while (left < right) {
      int l = height[left], r = height[right];
      int h = Math.min(l, r);
      maxArea = Math.max(maxArea, (right - left) * h);
      if (l < r)
        left++;
      else
        right--;
    }
    return maxArea;
  }
  // Lesson:
  // Traversal rules of two pointers need to conform to the data structure and the
  // problem features.
}
