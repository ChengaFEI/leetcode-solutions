class Solution {
  // Brute force
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
}
