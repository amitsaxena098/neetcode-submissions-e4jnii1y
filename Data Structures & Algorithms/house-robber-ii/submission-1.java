class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0];}
        if(nums.length == 2) { return Math.max(nums[0], nums[1]); }
        return Math.max(getRob(nums, 0, nums.length-2, new HashMap<>()), getRob(nums, 1, nums.length-1, new HashMap<>()));
    }
    public int getRob(int[] nums, int house, int len, Map<Integer, Integer> dp) {
        if(house == len) { return nums[house]; }
        if(house > len ) { return 0; }
        if(dp.containsKey(house)) {
            return dp.get(house);
        }
        int include = nums[house] + getRob(nums, house+2, len, dp);
        int notInclude = getRob(nums, house+1, len, dp);
        dp.put(house, Math.max(include, notInclude));
        return Math.max(include, notInclude);
    }
}
