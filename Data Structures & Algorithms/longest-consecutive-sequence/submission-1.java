class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int counter = 0;
        for(Integer i : set){
            int current = i;
            int currentCounter = 1;
            if(set.contains(current-1)) {
                continue;
            } else {
                while(set.contains(current+1)) {
                    currentCounter++;
                    current = current + 1;
                }
                counter = Math.max(counter, currentCounter);
            }
        }
        return counter;
    }
}
