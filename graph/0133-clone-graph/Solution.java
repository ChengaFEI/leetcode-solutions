import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  // Recursion + Hash Table
  // Time Complexity: O(V+E)
  // Space Complexity: O(V)
  public Node cloneGraph(Node node) {
    // Data Structure
    Map<Node, Node> mem = new HashMap<>();
    // Recursion
    return cloneGraphRec(node, mem);
  }

  private static Node cloneGraphRec(Node node, Map<Node, Node> mem) {
    // Corner Case
    if (node == null)
      return null;
    // Data Structure (return results)
    Node cloneNode = new Node(node.val);
    cloneNode.neighbors = new ArrayList<>();
    mem.put(node, cloneNode);
    // Recursion
    for (Node neighbor : node.neighbors) {
      if (!mem.containsKey(neighbor)) {
        Node cloneNeighbor = cloneGraphRec(neighbor, mem);
        mem.put(neighbor, cloneNeighbor);
      }
      cloneNode.neighbors.add(mem.get(neighbor));
    }
    return cloneNode;
  }
}

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}