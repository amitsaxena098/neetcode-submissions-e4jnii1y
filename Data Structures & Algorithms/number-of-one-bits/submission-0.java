class Solution {
    public int hammingWeight(int n) {
        
        int sum = 0;
        while(n != 0) {
            int res = n&1;
            if(res != 0) {
                sum++;
            }
            n = n >> 1;
        }
        return sum;
    }
}
