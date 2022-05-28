class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sold = new int[prices.length];
        buy[prices.length - 1] = 0;
        sold[prices.length - 1] = prices[prices.length - 1] - fee;
        for(int i = prices.length - 2; i >= 0; i--){
            buy[i] = Math.max(sold[i+1] - prices[i], buy[i+1]);
            sold[i] = Math.max(buy[i+1] + prices[i] - fee, sold[i+1]);
        }
        return buy[0];
    }
}