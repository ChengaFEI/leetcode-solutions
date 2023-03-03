import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
  // Graph Traversal
  // Time Complexity: O(n^2)
  // Space Complexity: O(n^2)
  public int[][] merge1(int[][] intervals) {
    // Step 0: Data Structure
    Map<int[], List<int[]>> graph = new HashMap<>();
    Map<Integer, List<int[]>> groups = new HashMap<>();
    List<int[]> merged = new ArrayList<>();
    // Step 2: Traverse
    // Build Graph
    buildGraph(intervals, graph);
    // Categorize Groups
    buildGroups(graph, groups);
    // Merge Groups
    mergeGroups(groups, merged);
    return merged.toArray(new int[merged.size()][]);
  }
  // Lesson:
  // Graph is useful in grouping nodes with same features but are not directly
  // related to each other.

  private static void buildGraph(int[][] intervals, Map<int[], List<int[]>> graph) {
    for (int[] interval : intervals)
      graph.put(interval, new ArrayList<int[]>());
    for (int[] interval1 : intervals) {
      for (int[] interval2 : intervals) {
        if (isOverlapped(interval1, interval2)) {
          graph.get(interval1).add(interval2);
          graph.get(interval2).add(interval1);
        }
      }
    }
  }

  private static boolean isOverlapped(int[] interval1, int[] interval2) {
    return interval1[1] >= interval2[0] && interval1[0] <= interval2[1];
  }

  private static void buildGroups(Map<int[], List<int[]>> graph, Map<Integer, List<int[]>> groups) {
    Set<int[]> visited = new HashSet<>();
    int index = 0;
    for (int[] interval : graph.keySet()) {
      if (!visited.contains(interval)) {
        Stack<int[]> toVisit = new Stack<>();
        toVisit.push(interval);
        while (!toVisit.isEmpty()) {
          int[] curInterval = toVisit.pop();
          visited.add(curInterval);
          if (!groups.containsKey(index))
            groups.put(index, new ArrayList<>());
          groups.get(index).add(curInterval);
          for (int[] childInterval : graph.get(curInterval)) {
            if (!visited.contains(childInterval))
              toVisit.push(childInterval);
          }
        }
        index++;
      }
    }
  }

  private static void mergeGroups(Map<Integer, List<int[]>> groups, List<int[]> merged) {
    for (List<int[]> group : groups.values())
      merged.add(mergeGroup(group));
  }

  private static int[] mergeGroup(List<int[]> group) {
    int minVal = group.get(0)[0], maxVal = group.get(0)[1];
    for (int[] interval : group) {
      minVal = Math.min(minVal, interval[0]);
      maxVal = Math.max(maxVal, interval[1]);
    }
    return new int[] { minVal, maxVal };
  }

  // Sorting + One-Pass In-Place Replacement
  // Time Complexity: (nlogn)
  // Space Complexity: O(logn) - O(n)
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0)
      return null;
    LinkedList<int[]> result = new LinkedList<>();
    Arrays.sort(intervals, (i1, i2) -> {
      return i1[0] - i2[0];
    });
    result.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] > result.getLast()[1])
        result.add(interval);
      else
        result.getLast()[1] = Math.max(interval[1], result.getLast()[1]);
    }
    return result.toArray(new int[result.size()][]);
  }
  // Lesson:
  // For array-based problems, if (optimized) brute force cost O(n^2) or more
  // time, we can first sort the array and prevent nested traversal in solutions.
}
