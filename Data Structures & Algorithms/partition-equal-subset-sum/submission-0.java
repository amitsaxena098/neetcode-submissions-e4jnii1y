class Solution {
    Map<Integer, Boolean> dp = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        if(total%2 != 0) {
            return false;
        }
        return getDiv(nums, total/2, 0);
    }

    public boolean getDiv(int[] nums, int total, int index) {
        if(total == 0) { return true;}
        if(index == nums.length-1) {
            return total == nums[index];
        }
        if(dp.containsKey(total)) {
            return dp.get(total);
        }
        boolean notTake = getDiv(nums, total, index+1);
        boolean take = false;
        if(total > nums[index]) {
            take = getDiv(nums, total - nums[index], index+1);
        }
        dp.put(total, notTake || take);
        return notTake || take;
    }
}
