public class Solution {
  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public boolean isValidBST1(TreeNode root) {
    return isValidBSTRec(root, null, null);
  }
  // Lesson:
  // Traverse a non-balanced tree using recursion algorithm might take up to
  // linear space because of the function call stack frame.

  private static boolean isValidBSTRec(TreeNode node, Integer min, Integer max) {
    // Variable Init
    int val = node.val;
    TreeNode left = node.left, right = node.right;
    // Traverse (recurse)
    if (min != null && val <= min)
      return false;
    if (max != null && val >= max)
      return false;
    Integer newMax = max == null ? val : Math.min(max, val);
    Integer newMin = min == null ? val : Math.max(min, val);
    if (left != null && !isValidBSTRec(left, min, newMax))
      return false;
    if (right != null && !isValidBSTRec(right, newMin, max))
      return false;
    return true;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
