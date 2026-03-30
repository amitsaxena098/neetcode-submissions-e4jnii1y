class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return profit(prices, 0, true);
    }

    public int profit(int[] prices, int index, boolean buy) {
        if(index >= prices.length) { return 0; }
        int profit;
        if(dp.containsKey(index+","+buy)) {
            return dp.get(index+","+buy);
        }
        if(buy) {
            profit = Math.max(profit(prices, index+1, false) - prices[index],
                    profit(prices, index+1, true));
        } else {
            profit = Math.max(prices[index] + profit(prices, index+2, true),
                    profit(prices, index+1, false));
        }
        dp.put(index+","+buy, profit);
        return profit;
    }
}
