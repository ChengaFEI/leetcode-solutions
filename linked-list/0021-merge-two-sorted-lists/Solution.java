public class Solution {
  // Two Pointers
  // Time Complexity: O(n1+n2)
  // Space Complexity: O(1)
  public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
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

  // Recursion
  // Time Complexity: O(n1+n2)
  // Space Complexity: O(n1+n2) number of stack frames
  public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;
    if (list1.val <= list2.val) {
      list1.next = mergeTwoLists2(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists2(list1, list2.next);
      return list2;
    }
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