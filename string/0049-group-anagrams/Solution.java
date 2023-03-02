import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  // Sort + Hash Map
  // Time Complexity: O(nklogk)
  // Space Complexity: O(nk) where n is the total number of strings in the list,
  // and k is the max length of strings in the list.
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> sorted = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sSorted = String.valueOf(chars);
      if (!sorted.containsKey(sSorted))
        sorted.put(sSorted, new ArrayList<>());
      sorted.get(sSorted).add(s);
    }
    return new ArrayList<>(sorted.values());
  }
  // Lesson:
  // If the time complexity of the brute force solution is greater than O(n^2), it
  // makes sense to sort the data structure first, for quicker query later.
}
