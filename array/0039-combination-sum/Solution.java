import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  // Recursion + Backtrack
  // Time Complexity: O(N^(T/M+1)) because the N-ary tree fans out N children in
  // each layer and there will be T/M layers at most. (loose upper bound)
  // Space Complexity: O(T/M) where T is the target value and M is the minimum
  // candidate value.
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Stack<Integer> combination = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, combination, result);
    return result;
  }

  private static void backtrack(int[] candidates, int target, int lastIndex, Stack<Integer> combination,
      List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<Integer>(combination));
      return;
    }
    if (target < 0)
      return;
    for (int i = lastIndex; i < candidates.length; i++) {
      int iVal = candidates[i];
      combination.push(iVal);
      backtrack(candidates, target - iVal, i, combination, result);
      combination.pop();
    }
  }
}
