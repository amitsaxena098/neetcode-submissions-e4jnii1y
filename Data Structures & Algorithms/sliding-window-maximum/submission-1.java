class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

      Deque<Integer> deq = new ArrayDeque<>();
      int l = 0;
      List<Integer> res = new ArrayList<>();

      for(int r = 0; r < nums.length; r++) {
        while(!deq.isEmpty() && deq.peekLast()<nums[r]) {
            deq.removeLast();
        }
        deq.addLast(nums[r]);
        if(r - l + 1 == k) {
            res.add(deq.peekFirst());
            if(!deq.isEmpty() && deq.peekFirst() == nums[l]) {
                deq.removeFirst();
            }
            l++;
        }
      }
      return res.stream().mapToInt(i->i).toArray();
        
    }
}
