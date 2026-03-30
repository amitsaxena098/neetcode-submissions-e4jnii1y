class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max,piles[i]);
        }

        int l = 1; 
        int ans = max;
        int r = max;
        while(l <= r) {
            int m = (l+r)/2;
            long totalHours = requiredTime(piles, m);
            if(totalHours > h ) {
                l = m+1;
            } else {
                ans = m;
                r = m-1;
            }
        }
        return ans;
        
    }

    public long requiredTime(int[] piles, int perHour) {
        long sum = 0;
        for(int i = 0; i < piles.length; i++) {
            sum += Math.ceil((double)piles[i]/(double)perHour);
        }
        return sum;
    }
}
