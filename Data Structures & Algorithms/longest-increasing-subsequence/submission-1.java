class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        return f(nums, 0, -1);
    }

    public int f(int[] nums, int index, int prev_index) {
        if(index >= nums.length) {
            return 0;
        }
        if(dp.containsKey(index+","+prev_index)) {
            return dp.get(index+","+prev_index);
        }
        int pick = 0;
        int notPick = f(nums, index+1, prev_index);
        if(prev_index == -1 || nums[index] > nums[prev_index]) {
            pick = 1 + f(nums, index+1, index);
        }
        dp.put(index+","+prev_index, Math.max(pick, notPick));
        return Math.max(pick, notPick);
    }
}
