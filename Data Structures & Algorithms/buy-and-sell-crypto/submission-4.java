class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;
        int r = 1;

        while (r <= prices.length - 1) {
            int profit = prices[r] - prices[l];
            if (profit > 0 && profit > max) {
                max = profit;
            } else if (profit > 0) {
                r++;
            } else {
                l = r;
                r++;
            }
        }

        return max;
    }
}
