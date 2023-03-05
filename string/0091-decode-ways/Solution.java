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

  // Iterative Dynamic Programming
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public int numDecodings2(String s) {
    // Data Structure
    int length = s.length();
    int[] nums = new int[length + 1];
    // Variable Init
    nums[length] = 1;
    nums[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
    // Traverse (iterate)
    for (int i = length - 2; i >= 0; i--) {
      char c = s.charAt(i);
      int n = c - '0';
      if (n > 2)
        nums[i] = nums[i + 1];
      else if (n == 2) {
        char nextC = s.charAt(i + 1);
        if (nextC - '0' < 7)
          nums[i] = nums[i + 1] + nums[i + 2];
        else
          nums[i] = nums[i + 1];
      } else if (n == 1)
        nums[i] = nums[i + 1] + nums[i + 2];
      else
        nums[i] = 0;
    }
    return nums[0];
  }
}
