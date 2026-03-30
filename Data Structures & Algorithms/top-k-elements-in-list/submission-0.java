class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i] , 0) + 1);
        }
        for(Integer key: freqMap.keySet()) {
            int freq = freqMap.get(key);
            bucket.get(freq).add(key);
        }
        int[] res = new int[k];
        int counter = 0;
        for(int i = nums.length; i >= 0 && counter < k ; i--) {
            for(Integer val : bucket.get(i)) {
                res[counter++] = val;
            }
        }
        return res;

    }
}
