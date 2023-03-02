import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
  private Map<Character, Character> pairs = new HashMap<>();

  public Solution() {
    pairs.put(')', '(');
    pairs.put(']', '[');
    pairs.put('}', '{');
  }

  // Stack
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (pairs.containsKey(c)) {
        char last = stack.isEmpty() ? '!' : stack.pop();
        if (last != pairs.get(c))
          return false;
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
  // Lesson: Traversal process of a palindromic string is similar to push/pop
  // process of a stack.
}
