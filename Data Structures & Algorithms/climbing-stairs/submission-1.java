class Solution {
    int ways = 0;
    Map<String, Integer> dp = new HashMap<>();
    public int climbStairs(int n) {

        return getCount(n, 0);
        
    }
    public int getCount(int n, int step) {
        if(step > n) return 0;
        if(step == n) {
            return 1;
        }
        if(dp.containsKey(n + "" + step)) {
            return dp.get(n+""+step);
        }
        int left = getCount(n, step+1);
        int right = getCount(n, step+2);
        dp.put(n+""+step, left+right);
        return left + right;
    }
}
