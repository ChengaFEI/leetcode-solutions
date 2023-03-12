public class Solution {
  // Two Pointers
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public boolean isPalindrome(String s) {
    // Corner Case
    if (s == null)
      return false;
    // Variable Init
    int length = s.length(), left = 0, right = length - 1;
    // Iterate
    while (left <= right) {
      while (left < length && !Character.isLetterOrDigit(s.charAt(left)))
        left++;
      while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
        right--;
      if (left > right)
        return true;
      char leftChar = Character.toLowerCase(s.charAt(left));
      char rightChar = Character.toLowerCase(s.charAt(right));
      if (leftChar != rightChar)
        return false;
      left++;
      right--;
    }
    return true;
  }
  // Lesson:
  // Primitive types have no instance methods, so any changes to them should use
  // the static methods in the corresponding class.
}
