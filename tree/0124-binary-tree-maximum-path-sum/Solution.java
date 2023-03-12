public class Solution {
  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int maxPathSum(TreeNode root) {
    // Recursion
    return maxPathSumsRec(root, Integer.MIN_VALUE)[1];
  }

  private static int[] maxPathSumsRec(TreeNode node, int maxPathSum) {
    // Base Case
    if (node == null)
      return new int[] { 0, maxPathSum };
    // Recursive Case
    int[] maxLeftSums = maxPathSumsRec(node.left, maxPathSum);
    int[] maxRightSums = maxPathSumsRec(node.right, maxPathSum);
    int maxSubPathSum = Math.max(maxLeftSums[1], maxRightSums[1]);
    int maxCurPathSum = Math.max(maxLeftSums[0] + maxRightSums[0] + node.val, maxSubPathSum);
    int maxCurLeftSum = Math.max(maxLeftSums[0] + node.val, 0);
    int maxCurRightSum = Math.max(maxRightSums[0] + node.val, 0);
    int maxCurSubSum = Math.max(maxCurLeftSum, maxCurRightSum);
    return new int[] { maxCurSubSum, maxCurPathSum };
  }
}
