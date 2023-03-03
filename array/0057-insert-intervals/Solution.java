import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  // Linear Search
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] insertedIntervals = insertNewInterval(intervals, newInterval);
    return mergeNewInterval(insertedIntervals);
  }
  // Lesson:
  // 1. Construct a new ArrayList from an existing array doesn't require extra RAM
  // space because it simply wraps/references the array and equips it with more
  // functions.
  // 2. ArrayList is a space-efficient way to manipulate an array, especially when
  // we need to mutate the capacity of an array.

  private static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
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

  private static int[][] mergeNewInterval(int[][] intervals) {
    // Data Structure (return solution)
    List<int[]> intervalsList = new ArrayList<>();
    // Traverse
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      while (i + 1 < intervals.length &&
          doesIntervalsOverlap(interval, intervals[i + 1])) {
        interval[0] = Math.min(interval[0], intervals[i + 1][0]);
        interval[1] = Math.max(interval[1], intervals[i + 1][1]);
        i++;
      }
      intervalsList.add(interval);
    }
    return intervalsList.toArray(new int[intervalsList.size()][2]);
  }

  private static boolean doesIntervalsOverlap(int[] interval1, int[] interval2) {
    return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
  }
}
