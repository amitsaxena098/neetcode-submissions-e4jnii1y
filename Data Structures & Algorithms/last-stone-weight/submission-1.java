class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        if(stones.length == 1) return stones[0]; 
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : stones) {
            q.offer(i);
        }
        while(q.size() != 1) {
            int top1 = q.poll();
            int top2 = q.poll();
            if(top1 == top2) {
                q.offer(0);
            } else {
                q.offer(Math.abs(top1 - top2));
            }
        }
        return q.peek();
        
    }
}
