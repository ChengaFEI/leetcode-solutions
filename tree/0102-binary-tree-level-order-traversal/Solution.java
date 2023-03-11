import java.util.ArrayList;
import java.util.List;

public class Solution {
  // Recurse
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
}
