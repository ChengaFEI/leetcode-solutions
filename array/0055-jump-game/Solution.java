import java.util.Arrays;

class Solution {
  // Dynamic Programming + Recursion
  // Time Complexity: O(n^2)
  // Space Complexity: O(2n) = O(n)
  public boolean canJump1(int[] nums) {
    // Step X: Corner Case
    if (nums == null || nums.length == 0)
      return false;
    // Step 0: Data Structrue
    int length = nums.length;
    IndexStat[] mem = new IndexStat[length];
    // Step 1: Data Init
    Arrays.fill(mem, IndexStat.UNKNOWN);
    mem[length - 1] = IndexStat.GOOD;
    // Step 2: Iterate
    return canJumpFromIndex(nums, 0, mem);
  }
  // Lesson:
  // Dynamic Programming is the optimized brute force traversal which prevents
  // repetitive calculation.

  private static boolean canJumpFromIndex(int[] nums, int index, IndexStat[] mem) {
    if (mem[index] == IndexStat.UNKNOWN) {
      IndexStat stat = IndexStat.BAD;
      int furthestJump = Math.min(nums.length - 1, index + nums[index]);
      for (int i = index + 1; i <= furthestJump; i++) {
        if (canJumpFromIndex(nums, i, mem)) {
          stat = IndexStat.GOOD;
          break;
        }
      }
      mem[index] = stat;
    }
    return mem[index] == IndexStat.GOOD ? true : false;
  }
}

enum IndexStat {
  GOOD, BAD, UNKNOWN
}