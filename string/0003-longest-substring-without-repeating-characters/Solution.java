import java.util.HashSet;
import java.util.Set;

public class Solution {
  // Brute Force
  // Time Complexity: O(n^3)
  // Space Complexity: O(min(n,m)) where n is the length of input String s, m is
  // the size of charset/alphabet.
  public int lengthOfLongestSubstring1(String s) {
    int length = s.length();
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i; j < length; j++) {
        if (checkCharsUnique(s, i, j)) {
          result = Math.max(result, j - i + 1);
        }
      }
    }
    return result;
  }

  private static boolean checkCharsUnique(String s, int start, int end) {
    Set<Character> chars = new HashSet<>();
    for (int i = start; i <= end; i++) {
      char c = s.charAt(i);
      if (chars.contains(c))
        return false;
      chars.add(c);
    }
    return true;
  }
}
