class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {
                int t = nums[i] + nums[j];
                int invert_t = (-1) * t;
                if(set.contains(invert_t)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], invert_t);
                    Collections.sort(temp);
                    if(!map.contains(Objects.hash(temp.get(0), temp.get(1), temp.get(2)))) {
                        res.add(temp);
                        map.add(Objects.hash(temp.get(0), temp.get(1), temp.get(2)));
                    }
                }
                set.add(nums[j]);
            }
        }
        return res;
    }
}
