import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public List<List<Integer>> levelOrder1(TreeNode root) {
    // Data Structure (return result)
    List<List<Integer>> levels = new ArrayList<>();
    // Recurse
    levelOrderRec(root, levels, 0);
    return levels;
  }
  // Lesson:
  // In the worst case where the tree is highly imbalanced and even reduced to a
  // linked list, the space complexity will be O(n).

  private static void levelOrderRec(TreeNode node, List<List<Integer>> levels, int level) {
    // Corner Case
    if (node == null)
      return;
    // Variable Init
    if (levels.size() == level)
      levels.add(new ArrayList<Integer>());
    // Recurse
    levels.get(level).add(node.val);
    levelOrderRec(node.left, levels, level + 1);
    levelOrderRec(node.right, levels, level + 1);
  }

  // Iteration
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public List<List<Integer>> levelOrder2(TreeNode root) {
    // Corner Case
    List<List<Integer>> levels = new ArrayList<>(); // return result
    if (root == null)
      return levels;
    // Data Structure
    Queue<TreeNode> nodes = new LinkedList<>();
    // Variable Init
    nodes.add(root);
    int level = 0;
    // Iterate
    while (!nodes.isEmpty()) {
      levels.add(new ArrayList<>());
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.remove();
        levels.get(level).add(node.val);
        if (node.left != null)
          nodes.add(node.left);
        if (node.right != null)
          nodes.add(node.right);
      }
      level++;
    }
    return levels;
  }
  // Lesson:
  // Flags in the recursion is kept and updated in the recursive function, but
  // flags in the iteration is kept and updated in the while loop.
}
