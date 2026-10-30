class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int sell = prices[n-1];

        for(int i=n-1; i>=0; i--){
            profit = Math.max(profit, sell - prices[i]); 
            sell = Math.max(sell, prices[i]);
        }

        return profit;
    }
}
