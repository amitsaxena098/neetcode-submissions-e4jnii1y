class TaskQueue {
    int rem;
    int avail;

    TaskQueue(int rem, int avail) {
        this.rem = rem;
        this.avail = avail;
    }
    public int getRem() { return this.rem; }
    public int getAvail() { return this.avail; } 
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        for(Character key : map.keySet()) {
            pq.offer(map.get(key));
        }
        Deque<TaskQueue> dq = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !dq.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int curr = pq.poll();
                int rem = curr-1;
                if(rem != 0) {
                    dq.offerLast(new TaskQueue(rem, time + n));
                }
            }
            if(!dq.isEmpty() && dq.peekFirst().getAvail() == time) {
                TaskQueue q = dq.pollFirst();
                pq.offer(q.rem);
            }

            
        }
        return time;

    }
}
