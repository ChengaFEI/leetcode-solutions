import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

  // Sliding Window / Two Pointers + Hash Table
  // Time Complexity: O(2n) = O(n)
  // Space Complexity: O(min(n,m)) where n is the length of input String s, m is
  // the size of charset/alphabet.
  public int lengthOfLongestSubstring2(String s) {
    int left = 0, right = 0, result = 0;
    Map<Character, Integer> chars = new HashMap<>();
    while (right < s.length()) {
      char r = s.charAt(right);
      chars.put(r, chars.getOrDefault(r, 0) + 1);
      while (chars.get(r) > 1) {
        char l = s.charAt(left);
        chars.put(l, chars.get(l) - 1);
        left++;
      }
      result = Math.max(result, right - left + 1);
      right++;
    }
    return result;
  }
  // Lesson:
  // HashMap is an advanced HashSet. It allows more types of values to be
  // traced instead of the key itself.

  // Optimized Sliding Window / Skipping Two Pointers + Hash Table
  // Time Complexity: O(n)
  // Space Complexity: O(min(n,m)) where n is the length of input String s, m is
  // the size of charset/alphabet.
  public int lengthOfLongestSubstring3(String s) {
    int left = 0, right = 0, result = 0;
    Map<Character, Integer> chars = new HashMap<>();
    while (right < s.length()) {
      char r = s.charAt(right);
      if (chars.containsKey(r)) {
        left = Math.max(left, chars.get(r));
      }
      chars.put(r, right + 1);
      result = Math.max(result, right - left + 1);
      right++;
    }
    return result;
  }
  // Lesson:
  // Store the position of characters instead of occurence number in the HashMap.
  // Then left pointer doesn't need to traverse the String, it can directly jump
  // to the next of repeated character.
}
