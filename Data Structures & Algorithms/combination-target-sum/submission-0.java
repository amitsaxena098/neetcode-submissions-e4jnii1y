class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        sum(nums, target, 0, 0, list);
        return res;
    }
    public void sum(int[] nums, int target, int index, int currentSum, List<Integer> list) {
        if(currentSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(index > nums.length-1) return;
        if(currentSum > target) return;
        
        List<Integer> copyList = new ArrayList<>(list);
        copyList.add(nums[index]);
        sum(nums, target, index, currentSum + nums[index], copyList);
        sum(nums, target, index+1, currentSum, list);
        // sum(nums, target, index+1, currentSum , list);
    }
}
