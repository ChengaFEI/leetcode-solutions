import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  // Linear Search
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int[][] insert1(int[][] intervals, int[] newInterval) {
    int[][] insertedIntervals = insertNewInterval1(intervals, newInterval);
    return mergeNewInterval1(insertedIntervals);
  }
  // Lesson:
  // 1. Construct a new ArrayList from an existing array doesn't require extra RAM
  // space because it simply wraps/references the array and equips it with more
  // functions.
  // 2. ArrayList is a space-efficient way to manipulate an array, especially when
  // we need to mutate the capacity of an array.

  private static int[][] insertNewInterval1(int[][] intervals, int[] newInterval) {
    // Data Structure (no extra space)
    List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
    // Variable Init
    boolean isInserted = false;
    // Traverse
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] > newInterval[0]) {
        isInserted = true;
        intervalsList.add(i, newInterval);
        break;
      }
    }
    if (!isInserted)
      intervalsList.add(newInterval);
    return intervalsList.toArray(new int[intervalsList.size()][2]);
  }

  private static int[][] mergeNewInterval1(int[][] intervals) {
    // Data Structure (return solution)
    List<int[]> intervalsList = new ArrayList<>();
    // Traverse
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      while (i + 1 < intervals.length &&
          doesIntervalsOverlap1(interval, intervals[i + 1])) {
        interval[0] = Math.min(interval[0], intervals[i + 1][0]);
        interval[1] = Math.max(interval[1], intervals[i + 1][1]);
        i++;
      }
      intervalsList.add(interval);
    }
    return intervalsList.toArray(new int[intervalsList.size()][2]);
  }

  private static boolean doesIntervalsOverlap1(int[] interval1, int[] interval2) {
    return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
  }

  // Binary Search
  // Time Complexity: O(n) - O(logn) for binary search, O(n) for iterative merge
  // Space Complexity: O(1)
  public int[][] insert2(int[][] intervals, int[] newInterval) {
    // Corner Case
    if (intervals == null || intervals.length == 0)
      return new int[][] { newInterval };
    // Traverse
    int[][] insertedIntervals = insertNewInterval2(intervals, newInterval);
    return mergeNewInterval2(insertedIntervals);
  }

  private static int[][] insertNewInterval2(int[][] intervals, int[] newInterval) {
    // Data Structure (no extra space)
    List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
    // Variable Init
    int left = 0, right = intervals.length - 1, index = intervals.length;
    // Traverse
    while (left <= right) {
      int middle = (left + right) / 2;
      int[] interval = intervals[middle];
      if (interval[0] >= newInterval[0]) {
        index = middle;
        right = middle - 1;
      } else
        left = middle + 1;
    }
    if (index == intervals.length)
      intervalsList.add(newInterval);
    else
      intervalsList.add(index, newInterval);
    return intervalsList.toArray(new int[intervalsList.size()][2]);
  }

  private static int[][] mergeNewInterval2(int[][] intervals) {
    // Data Structure (return solutions)
    List<int[]> intervalsList = new ArrayList<>();
    // Traverse
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      while (i + 1 < intervals.length && doesOverlap2(interval, intervals[i + 1])) {
        interval[0] = Math.min(interval[0], intervals[i + 1][0]);
        interval[1] = Math.max(interval[1], intervals[i + 1][1]);
        i++;
      }
      intervalsList.add(interval);
    }
    return intervalsList.toArray(new int[intervalsList.size()][2]);
  }

  private static boolean doesOverlap2(int[] interval1, int[] interval2) {
    return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
  }
}
