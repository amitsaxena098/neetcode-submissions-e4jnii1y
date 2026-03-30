class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            prefixSum[i] = prefixSum[i] * suffix;
            suffix = suffix * nums[i];
        }
        return prefixSum;
    
}  
}
