public class Solution {
  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // Base Case
    if (p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    // Recursive Case
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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