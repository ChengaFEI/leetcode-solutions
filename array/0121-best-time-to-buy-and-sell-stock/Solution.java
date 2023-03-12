public class Solution {
  // Iteration
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public int maxProfit(int[] prices) {
    // Variable Init
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    // Iterate
    for (int i = 0; i < prices.length; i++) {
      int delta = prices[i] - minPrice;
      if (delta < 0)
        minPrice = prices[i];
      else if (delta > maxProfit)
        maxProfit = delta;
    }
    return maxProfit;
  }
}
