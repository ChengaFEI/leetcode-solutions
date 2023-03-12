import java.util.Arrays;

public class Solution {
  // Sorting + One-Pass Iteration
  // Time Complexity: O(nlogn)
  // Space Complexity: O(1)/O(n) (depends on whether the input array is
  // modifiable)
  public int longestConsecutive(int[] nums) {
    // Corner Case
    if (nums == null || nums.length == 0)
      return 0;
    // Variable Init
    int maxStreak = 1, curStreak = 1;
    // Sort
    Arrays.sort(nums);
    // Iterate
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        if (nums[i] == nums[i - 1] + 1)
          curStreak++;
        else {
          maxStreak = Math.max(maxStreak, curStreak);
          curStreak = 1;
        }
      }
    }
    return Math.max(maxStreak, curStreak);
  }
}
