class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums, target, 0, 0);
    }
    public int targetSum(int[] nums, int target, int index, int sum) {
        if(index >= nums.length && target == sum) { return 1; }
        if(index >= nums.length) { return 0; }
        if(dp.containsKey(index+","+sum)) {
            return dp.get(index+","+sum);
        }
        int res = targetSum(nums, target, index+1, sum + nums[index]) + targetSum(nums, target, index+1, sum - nums[index]);
        dp.put(index+","+sum, res);
        return res;
    }
}
