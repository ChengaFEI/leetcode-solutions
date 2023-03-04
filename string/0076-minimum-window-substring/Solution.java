import java.util.HashMap;
import java.util.Map;

public class Solution {
  // Sliding Window
  // Time Complexity: O(S + T) where S is the length of String s, T is the length
  // of String t.
  // Space Complexity: O(min(T, N)) where T is the length of String t, N is the
  // number of chars in the charset.
  public String minWindow(String s, String t) {
    // Corner Case
    if (s == null || s.length() == 0)
      return "";
    if (t == null || t.length() == 0)
      return "";
    // Data Structure
    Map<Character, Integer> charCountNeeded = new HashMap<>();
    int charNeeded, lenCap = s.length() + 1, left = 0, right = 0;
    int[] minLen = { lenCap, left, right };
    // Variable Init (traverse)
    for (int i = 0; i < t.length(); i++) {
      char curChar = t.charAt(i);
      charCountNeeded.put(curChar, charCountNeeded.getOrDefault(curChar, 0) + 1);
    }
    charNeeded = charCountNeeded.size();
    // Traverse
    while (right < s.length()) {
      // Expand right pointer
      char addChar = s.charAt(right);
      if (charCountNeeded.containsKey(addChar)) {
        charCountNeeded.put(addChar, charCountNeeded.get(addChar) - 1);
        if (charCountNeeded.get(addChar) == 0)
          charNeeded--;
        // Contract left pointer
        while (charNeeded < 1) {
          if (right - left + 1 < minLen[0])
            minLen = new int[] { right - left + 1, left, right };
          char delChar = s.charAt(left);
          if (charCountNeeded.containsKey(delChar)) {
            charCountNeeded.put(delChar, charCountNeeded.get(delChar) + 1);
            if (charCountNeeded.get(delChar) > 0)
              charNeeded++;
          }
          left++;
        }
      }
      right++;
    }
    return minLen[0] == lenCap ? "" : s.substring(minLen[1], minLen[2] + 1);
  }
}