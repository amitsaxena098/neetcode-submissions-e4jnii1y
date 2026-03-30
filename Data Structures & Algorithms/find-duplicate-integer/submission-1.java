class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                res = nums[i];
            }
            nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
        }
        return Math.abs(res);
    }
}
