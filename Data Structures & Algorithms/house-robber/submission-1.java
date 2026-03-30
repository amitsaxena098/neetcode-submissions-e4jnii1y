class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0];}
        if(nums.length == 2) { return Math.max(nums[0], nums[1]); }
        return getRob(nums, 0);
    }
    public int getRob(int[] nums, int house) {
        if(house == nums.length-1) { return nums[house]; }
        if(house > nums.length-1 ) { return 0; }
        if(dp.containsKey(house)) {
            return dp.get(house);
        }
        int include = nums[house] + getRob(nums, house+2);
        int notInclude = getRob(nums, house+1);
        dp.put(house, Math.max(include, notInclude));
        return Math.max(include, notInclude);
    }
}
