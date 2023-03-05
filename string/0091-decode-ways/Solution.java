import java.util.HashMap;
import java.util.Map;

public class Solution {
  // Recursive Dynamic Programming + Memorization
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int numDecodings1(String s) {
    // Data Structure
    Map<Integer, Integer> mem = new HashMap<>();
    // Traverse (recurse)
    return numDecodingsRec(s, 0, mem);
  }

  private static int numDecodingsRec(String s, int index, Map<Integer, Integer> mem) {
    // Corner Case
    int length = s.length();
    if (index == length)
      return 1;
    if (index > length)
      return 0;
    char c = s.charAt(index);
    int n = c - '0';
    // Traverse (recurse)
    if (!mem.containsKey(index)) {
      int num1 = numDecodingsRec(s, index + 1, mem);
      int num2 = numDecodingsRec(s, index + 2, mem);
      if (n == 0)
        mem.put(index, 0);
      else if (n == 1)
        mem.put(index, num1 + num2);
      else if (n == 2) {
        if (index < length - 1 && s.charAt(index + 1) - '0' < 7)
          mem.put(index, num1 + num2);
        else
          mem.put(index, num1);
      } else
        mem.put(index, num1);
    }
    return mem.get(index);
  }
}
