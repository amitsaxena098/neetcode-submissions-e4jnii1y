class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> thisSubset = new ArrayList<>();
        subset(res, nums, thisSubset, 0);
        return res;
    }
    public void subset(List<List<Integer>> res, int[] nums, List<Integer> thisSubset, int i) {
        if(i > nums.length-1) {
            res.add(thisSubset);
            return;
        }
        List<Integer> list = new ArrayList<>(thisSubset);
        thisSubset.add(nums[i]);
        subset(res, nums, thisSubset, i+1);

        subset(res, nums, list, i+1);
    }
}
