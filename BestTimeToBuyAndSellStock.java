class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE, profit = 0, index = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            index = prices[i] - min;
            if (profit < index) {
                profit = index;
            }
        }
        return profit;

    }
}
