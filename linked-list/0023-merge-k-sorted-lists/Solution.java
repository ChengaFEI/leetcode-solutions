public class Solution {
  // Brute Force
  // Time Complexity: O(k*N) where k is the number of linked lists and N is the
  // sum of nodes in all lists.
  // Space Complexity: O(N) where N is the sum of nodes in all lists.
  public ListNode mergeKLists1(ListNode[] lists) {
    int index = -1;
    int minVal = (1 << 31) - 1;
    for (int i = 0; i < lists.length; i++) {
      ListNode node = lists[i];
      if (node != null && node.val < minVal) {
        index = i;
        minVal = node.val;
      }
    }
    ListNode minNode = null;
    if (index > -1) {
      minNode = lists[index];
      lists[index] = minNode.next;
      minNode.next = mergeKLists1(lists);
    }
    return minNode;
  }

  // Divide and Conquer + In-place Replacement
  // Time Complexity: O(Nlogk) where N is the total number of nodes in all lists,
  // k is the number of lists.
  // Space Complexity: O(1)
  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    int interval = 1;
    while (interval < lists.length) {
      for (int i = 0; i < lists.length - interval; i += interval * 2) {
        lists[i] = merge2Lists(lists[i], lists[i + interval]);
      }
      interval *= 2;
    }
    return lists[0];
  }
  // Lesson:
  // Divide and Conquer is efficient to divide a large problem into sub-problems
  // with same structures and prevent repetitive traversal.

  private static ListNode merge2Lists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode node = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        node.next = l1;
        l1 = l1.next;
      } else {
        node.next = l2;
        l2 = l2.next;
      }
      node = node.next;
    }
    if (l1 != null)
      node.next = l1;
    else
      node.next = l2;
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