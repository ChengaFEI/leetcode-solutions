public class Solution {
  // Recursion + Counter
  // Time Complexity: O(n) one-pass
  // Space Complexity: O(1)
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    countAndRemove(dummy, n);
    return dummy.next;
  }
  // Lesson: Use dummy node before the head node to simplify corner cases like the
  // linked list with only one node or removing the head node.

  private static int countAndRemove(ListNode node, int n) {
    if (node == null)
      return 0;
    int nextCount = countAndRemove(node.next, n);
    if (nextCount == n) {
      ListNode next = node.next;
      node.next = node.next.next;
      next.next = null;
    }
    return nextCount + 1;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
