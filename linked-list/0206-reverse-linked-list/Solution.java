public class Solution {
  // Recursion
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public ListNode reverseList(ListNode head) {
    // Corner/Base Case
    if (head == null || head.next == null)
      return head;
    // Recursion
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
// Lesson:
// If a recursion doesn't require any flags/memories, we can directly use the
// main function for recursion.

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