class Solution {
    int ans = Integer.MAX_VALUE;
    Map<Integer, Integer> dp = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        ans = getCoin(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int getCoin(int[] coins, int amount, int noOfCoins) {
        if(amount == 0) {
            return 0;
        }
        int totalCoins = Integer.MAX_VALUE;
        if(dp.containsKey(amount)) {
            return dp.get(amount);
        }
        for(int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]) {
                int res = getCoin(coins, amount - coins[i], noOfCoins+1);
                if(res != Integer.MAX_VALUE)
                    totalCoins =  Math.min(totalCoins, 1 + res);
            }
        }
        dp.put(amount, totalCoins);
        return totalCoins;
    }
}
