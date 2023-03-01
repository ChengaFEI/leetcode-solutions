import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  // Sort + Two Sum II
  // Time Complexity: O(n^2)
  // Space Complexity: O(logn) - O(n) (depending on sort algorithm)
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3)
      return null;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Quick sort (O(nlogn))
    for (int index = 0; index < nums.length; index++) {
      if (index == 0 || nums[index] != nums[index - 1])
        twoSum(nums, index, result);
    }
    return result;
  }
  // Lesson:
  // In complicated array problems whose brute force solution requires a time
  // complexity of O(n^2) or larger, we can first sort the array, because quick
  // sort normally use O(nlogn) time.

  private static void twoSum(int[] nums, int index, List<List<Integer>> result) {
    int left = index + 1, right = nums.length - 1;
    while (left < right) {
      int i = nums[index], l = nums[left], r = nums[right];
      int sum = i + l + r;
      if (sum > 0)
        right--;
      else if (sum < 0)
        left++;
      else {
        result.add(Arrays.asList(i, l, r));
        left++;
        right--;
        while (left < right && nums[left] == nums[left - 1])
          left++;
      }
    }
  }
}
