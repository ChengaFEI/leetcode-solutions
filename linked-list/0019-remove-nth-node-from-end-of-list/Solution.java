public class Solution {
  // Recursion + Counter
  // Time Complexity: O(n) one-pass
  // Space Complexity: O(1)
  public ListNode removeNthFromEnd1(ListNode head, int n) {
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

  // Fast-Slow Pointers
  // Time Complexity: O(n) one-pass
  // Space Complexity: O(1)
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i <= n; i++)
      fast = fast.next;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode next = slow.next;
    slow.next = slow.next.next;
    next.next = null;
    return dummy.next;
  }
  // Lesson: Use fast-slow pointers pair to transform a reversed searching problem
  // to a forward searching problem.
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
