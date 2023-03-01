import java.util.HashMap;
import java.util.Map;

class Solution {
  // Brute Force
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public int[] twoSum1(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }

  // Consider the target's constraints -10^9 <= target <= 10^9
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public int[] twoSum2(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }

  // One-pass Hash Table
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { i, map.get(complement) };
      }
      map.put(nums[i], i);
    }
    return null;
  }
  // Lesson:
  // Use hash table to re-organize the given data structure for more efficient
  // query. Put the easily accessible property as key, put property to query as
  // the value.
}
