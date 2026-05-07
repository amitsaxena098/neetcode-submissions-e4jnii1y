class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        count(nums, new ArrayList<>(), 0);
        return res;
    }

    public void count(int[] nums, List<Integer> curr, int index) {
        res.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i-1] == nums[i]) {
                continue;
            }
            curr.add(nums[i]);
            count(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }


}
