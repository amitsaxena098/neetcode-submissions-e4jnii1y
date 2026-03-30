class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int runningSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            runningSum = Math.max(runningSum + nums[i], nums[i]);
            res = Math.max(runningSum, res);
        }
        return res;
    }
    
}
