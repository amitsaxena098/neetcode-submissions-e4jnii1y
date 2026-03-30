class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        Arrays.fill(flags, false);
        per(nums, new ArrayList<>(), flags);
        return res;
    }
    public void per(int[] nums, List<Integer> curr, boolean[] flags) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        List<Integer> thisCurr = new ArrayList<>(curr);
        for(int i = 0; i<nums.length; i++) {
            if(flags[i] == false) {
                flags[i] = true;
                thisCurr.add(nums[i]);
                per(nums, thisCurr, flags);
                flags[i] = false; 
                thisCurr.remove(thisCurr.size()-1);
            }
        }
    }
}
