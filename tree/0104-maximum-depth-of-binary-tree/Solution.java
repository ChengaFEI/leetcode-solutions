public class Solution {
  private static int maxDepth;

  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int maxDepth(TreeNode root) {
    maxDepth = 0;
    maxDepthRec(root, 0);
    return maxDepth;
  }
  // Lesson:
  // Primitive types are passed by copy across function calls, so changes made
  // in recursion can not be passed out of recursion. Instead, we need to use
  // global variables.

  private static void maxDepthRec(TreeNode node, int curLevel) {
    // Corner Case
    if (node == null)
      maxDepth = Math.max(maxDepth, curLevel);
    // Recurse
    else {
      maxDepthRec(node.left, curLevel + 1);
      maxDepthRec(node.right, curLevel + 1);
    }
  }
}
