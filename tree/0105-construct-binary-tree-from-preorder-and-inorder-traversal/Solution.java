import java.util.HashMap;
import java.util.Map;

public class Solution {
  private static int preorderPtr;

  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Data structure
    Map<Integer, Integer> inorderMap = new HashMap<>();
    // Variable Init (iterate)
    preorderPtr = 0;
    for (int i = 0; i < inorder.length; i++)
      inorderMap.put(inorder[i], i);
    // Recurse
    return buildTreeRec(preorder, inorderMap, 0, inorder.length - 1);
  }
  // Lesson:
  // All global flags mush be re-initialized before creating a new instance or
  // starting a new function call.

  private static TreeNode buildTreeRec(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right) {
    // Base Case
    if (left > right)
      return null;
    // Recursive Case
    int nodeVal = preorder[preorderPtr++];
    TreeNode node = new TreeNode(nodeVal);
    int newRight = inorderMap.get(nodeVal) - 1;
    int newLeft = inorderMap.get(nodeVal) + 1;
    node.left = buildTreeRec(preorder, inorderMap, left, newRight);
    node.right = buildTreeRec(preorder, inorderMap, newLeft, right);
    return node;
  }
}
