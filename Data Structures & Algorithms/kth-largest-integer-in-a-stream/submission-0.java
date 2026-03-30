class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int globalK = 0;
    public KthLargest(int k, int[] nums) {
        this.globalK = k;
        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > globalK) {
            pq.poll();
        }
        return pq.peek();
    }
}
