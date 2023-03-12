import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  // Sorting + One-Pass Iteration
  // Time Complexity: O(nlogn)
  // Space Complexity: O(1)/O(n) (depends on whether the input array is
  // modifiable)
  public int longestConsecutive1(int[] nums) {
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

  // HashTable
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int longestConsecutive2(int[] nums) {
    // Corner Case
    if (nums == null || nums.length == 0)
      return 0;
    // Data Structure
    Set<Integer> numSet = new HashSet<>();
    // Variable Init
    int maxStreak = 1, curStreak = 1;
    // Iterate
    for (int num : nums)
      numSet.add(num);
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        while (numSet.contains(num + 1)) {
          curStreak++;
          num++;
        }
        maxStreak = Math.max(maxStreak, curStreak);
        curStreak = 1;
      }
    }
    return maxStreak;
  }
  // Lesson:
  // One of the hash table's advantages is to ensure contant time querying.
}
