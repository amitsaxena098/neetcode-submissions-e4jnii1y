class Solution {
    public int maxProduct(int[] nums) {
        return usingPreffixSuffix(nums);
    }

    public int usingPreffixSuffix(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0) {
                prefix = 1;
            }

            if(suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[nums.length - i - 1];
            
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

    public int product(int[] nums, int index) {
       if(index >= nums.length) { return 1; }

       int pick = nums[index] * product(nums, index+1);
       int notPick = product(nums, index+1);

       return Math.max(pick, notPick);
    }
}
