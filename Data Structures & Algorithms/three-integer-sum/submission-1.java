class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 1 && nums[i-1] == nums[i]) {
                continue;
            }
            int j = i + 1, k = nums.length-1;
            while(j < k) {
                if( !(j > i + 1 && nums[j-1] == nums[j]) ) {
                    if(nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else if(nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else {
                        if(!set.contains(Objects.hash(nums[i] , nums[j] , nums[k]))) {

                            res.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                            set.add(Objects.hash(nums[i] , nums[j] , nums[k]));
                        }
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }
        return res;
        // List<List<Integer>> res = new ArrayList<>();
        // Set<Integer> map = new HashSet<>();
        // for(int i = 0; i < nums.length; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i+1; j < nums.length; j++) {
        //         int t = nums[i] + nums[j];
        //         int invert_t = (-1) * t;
        //         if(set.contains(invert_t)) {
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], invert_t);
        //             Collections.sort(temp);
        //             if(!map.contains(Objects.hash(temp.get(0), temp.get(1), temp.get(2)))) {
        //                 res.add(temp);
        //                 map.add(Objects.hash(temp.get(0), temp.get(1), temp.get(2)));
        //             }
        //         }
        //         set.add(nums[j]);
        //     }
        // }
        // return res;
    }
}
