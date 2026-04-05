class Solution {
    public int trap(int[] height) {
        
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        prefixMax[0] = suffixMax[height.length-1] = 0;
        int maxLeft = Math.max(0, height[0]);
        int maxRight = Math.max(0, height[height.length-1]);
        for(int i = 1; i < height.length; i++) {
            prefixMax[i] = maxLeft;
            suffixMax[height.length-i-1] = maxRight;
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[height.length-i-1]);
        }
    
        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            int pot = Math.min(prefixMax[i], suffixMax[i]);
            sum += Math.max(0, pot-height[i]);
        }
        return sum;
    }
}
