class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int currMax = 0;
        for(int i = prices.length-1; i >= 0; i--) {
            if(prices[i] > currMax) {
                currMax = prices[i];
            } else if(prices[i] < currMax) {
                max = Math.max(max, currMax - prices[i]);
            }
        }
        return max;
    }
}
