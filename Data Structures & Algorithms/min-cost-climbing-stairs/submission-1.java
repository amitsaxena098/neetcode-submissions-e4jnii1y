class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(getCost(cost, 0), getCost(cost,1));
    }

    public int getCost(int[] cost, int step) {
        if(step == cost.length-1) {
            return cost[step];
        }
        if(step > cost.length-1) {
            return 0;
        }
        int left;
        int right;
        if(dp.containsKey(step + "" + (step+1))) {
            left = dp.get(step + "" + (step+1));
        } else {
            left = cost[step] + getCost(cost, step+1);
            dp.put(step+""+(step+1), left);
        }
        if(dp.containsKey(step + "" + (step+2))) {
            right = dp.get(step + "" + (step+2));
        } else {
            right = cost[step] + getCost(cost, step+2);
            dp.put(step+""+(step+2), right);
        }
        return Math.min(left, right);
    }
}
