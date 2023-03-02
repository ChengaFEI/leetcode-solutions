import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  // Recursion + Backtracking
  // Time Complexity: O(K*P(9, K)) = O(K*9!/(9-K)!)
  // Space Complexity: O(K) where K is the number of a valid combination.
  public List<List<Integer>> combinationSum3(int k, int n) {
    Stack<Integer> combination = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    backtrack(n, k, 0, combination, result);
    return result;
  }
  // Lesson:
  // Keys to recursion: base case (terminating condition / when to terminate or
  // return output), recursion case (proceeding condition / how to proceed from
  // one step to next)

  private static void backtrack(int nRemain, int k, int lastInt, Stack<Integer> combination,
      List<List<Integer>> result) {
    int numComb = combination.size();
    if (nRemain == 0 && numComb == k) {
      // O(K) - make a deep copy of the valid combination with K elements.
      result.add(new ArrayList<Integer>(combination));
      return;
    }
    if (nRemain < 0 || numComb == k)
      return;
    for (int i = lastInt + 1; i <= 9; i++) {
      // O(P(9, K)) = O(9!/(9-K)!) in the worst case where the sum n is super large
      // (>sum(1, 2, ..., 9))
      combination.push(i);
      backtrack(nRemain - i, k, i, combination, result);
      combination.pop();
    }
  }
}
