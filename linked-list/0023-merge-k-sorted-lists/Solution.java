public class Solution {
  // Brute Force
  // Time Complexity: O(k*N) where k is the number of linked lists and N is the
  // sum of nodes in all lists.
  // Space Complexity: O(N) where N is the sum of nodes in all lists.
  public ListNode mergeKLists(ListNode[] lists) {
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
      minNode.next = mergeKLists(lists);
    }
    return minNode;
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