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
    // Step 2: Traverse
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
    return mem[index] == IndexStat.GOOD;
  }

  // Dynamic Programming + Iteration
  // Time Complexity: O(n^2)
  // Space Complexity: O(n)
  public boolean canJump2(int[] nums) {
    // Step X: Corner Case
    if (nums == null || nums.length < 1)
      return false;
    // Step 0: Data Structure
    int length = nums.length;
    boolean[] mem = new boolean[length];
    // Step 1: Data Init
    mem[length - 1] = true;
    // Step 2: Traverse
    for (int i = length - 2; i >= 0; i--) {
      int furthestJump = Math.min(length - 1, i + nums[i]);
      boolean isGood = false;
      for (int j = i + 1; j <= furthestJump; j++) {
        if (mem[j]) {
          isGood = true;
          break;
        }
      }
      mem[i] = isGood;
    }
    return mem[0];
  }
  // Lesson:
  // Iteration algorithms for linked-list-based structures and array-based
  // structures are different --
  // Linked-list-based structures have no direct access to latter data, we can
  // only traverse former data first, latter data later; Array-based structures
  // have direct access to data in a random index. So, we have to use a Stack
  // object to memorize former data in the linked-list when iterating over the
  // structure; while, we can directly iterate an array from the end of the
  // structure, without using extra structure to store data.
}

enum IndexStat {
  GOOD, BAD, UNKNOWN
}