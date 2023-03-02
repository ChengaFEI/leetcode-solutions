public class Solution {
  // Two Pointers
  // Time Complexity: O(n1+n2)
  // Space Complexity: O(1)
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode node1 = list1;
    ListNode node2 = list2;
    ListNode node = dummy;
    while (node1 != null && node2 != null) {
      int val1 = node1.val, val2 = node2.val;
      if (val1 <= val2) {
        node.next = node1;
        node = node.next;
        node1 = node1.next;
      } else {
        node.next = node2;
        node = node.next;
        node2 = node2.next;
      }
    }
    while (node1 != null) {
      node.next = node1;
      node = node.next;
      node1 = node1.next;
    }
    while (node2 != null) {
      node.next = node2;
      node = node.next;
      node2 = node2.next;
    }
    return dummy.next;
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