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
  public List<List<String>> groupAnagrams1(String[] strs) {
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

  // Counting + Hash Table
  // Time Complexity: O(nk)
  // Space Complexity: O(nk)
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> mem = new HashMap<>();
    for (String s : strs) {
      int[] countArray = new int[26];
      Arrays.fill(countArray, 0);
      char[] charArray = s.toCharArray();
      for (char c : charArray)
        countArray[c - 'a']++;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append('|');
        sb.append(countArray[i]);
      }
      String sCounted = sb.toString();
      if (!mem.containsKey(sCounted))
        mem.put(sCounted, new ArrayList<>());
      mem.get(sCounted).add(s);
    }
    return new ArrayList<>(mem.values());
  }
  // Lesson:
  // When given data structure's information does not suffice to represent
  // features of the problem, we can use sorting/counting/... to generate new data
  // to represent the given structure. And we can keep the generated data in
  // memory if needed.
}
