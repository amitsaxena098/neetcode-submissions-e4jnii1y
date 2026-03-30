class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(l <= r) {
            int m = (l+r)/2;
            ans = Math.min(ans, nums[m]);
            if( (nums[l] <= nums[m]) && (nums[m] > nums[r])) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return ans;
    }
}
