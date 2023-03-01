public class Solution {
  // Two Pointers + Expand Around Center
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1)
      return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int lengthOdd = expandAroundCenter(s, i, i);
      int lengthEven = expandAroundCenter(s, i, i + 1);
      int length = Math.max(lengthOdd, lengthEven);
      if (length > end - start + 1) {
        start = i - (length - 1) / 2;
        end = i + length / 2;
      }
    }
    return s.substring(start, end + 1);
  }
  // Lesson:
  // Traversal rules of pointers should conform to the input data structure and
  // the problem's features.

  private static int expandAroundCenter(String s, int left, int right) {
    int l = left, r = right;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }
}
