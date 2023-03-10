public class Solution {
  // Two-Pass Binary Search
  // Time Complexity: O(logN)
  // Space Complexity: O(1)
  public int search1(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return -1;
    int minIndex = findMinIndex(nums);
    int lastIndex = nums.length - 1;
    if (minIndex == 0)
      return binarySearch(nums, 0, lastIndex, target);
    if (target < nums[0])
      return binarySearch(nums, minIndex, lastIndex, target);
    else
      return binarySearch(nums, 0, minIndex - 1, target);
  }
  // Lesson:
  // Split rotated sorted array into two sorted array.

  private static int findMinIndex(int[] nums) {
    int left = 0, right = nums.length - 1;
    if (nums[left] <= nums[right])
      return 0;
    while (left < right) {
      int middle = (left + right) / 2;
      if (nums[middle] > nums[middle + 1])
        return middle + 1;
      if (nums[middle] > nums[left])
        left = middle;
      else
        right = middle;
    }
    return 0;
  }

  private static int binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int middle = (left + right) / 2;
      int mVal = nums[middle];
      if (mVal == target)
        return middle;
      if (mVal > target)
        right = middle - 1;
      else
        left = middle + 1;
    }
    return -1;
  }

  // One-Pass Binary Search
  // Time Complexity: O(logN)
  // Space Complexity: O(1)
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return -1;
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      int m = nums[middle], l = nums[left], r = nums[right];
      if (m == target)
        return middle;
      if (l == target)
        return left;
      if (r == target)
        return right;
      if (m > l) {
        if (target > l && target < m) {
          right = middle - 1;
          left++;
        } else {
          left = middle + 1;
          right--;
        }
      } else {
        if (target > m && target < r) {
          left = middle + 1;
          right--;
        } else {
          right = middle - 1;
          left++;
        }
      }
    }
    return -1;
  }
  // Lesson:
  // In revised binary search, we can know whether the middle index locates in the
  // left half / right half of the rotated array simply by comparing the middle
  // value with the left bound value.
}
