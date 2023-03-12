import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  private static int maxDepth;

  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int maxDepth1(TreeNode root) {
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

  // Iteration
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int maxDepth2(TreeNode root) {
    // Corner Case
    if (root == null)
      return 0;
    // Data Structure
    Queue<TreeNode> nodes = new LinkedList<>();
    // Variable Init
    int maxDepth = 0;
    nodes.add(root);
    // Iterate
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.remove();
        if (node.left != null)
          nodes.add(node.left);
        if (node.right != null)
          nodes.add(node.right);
      }
      maxDepth++;
    }
    return maxDepth;
  }
}
