class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> {
            if(first[0] != second[0]) {
                return Integer.compare(first[0], second[0]);
            }
            return Integer.compare(first[1], second[1]);
        });

        for(int[] interval : intervals) {
            pq.offer(interval);
        }
        // for(int[] interval : pq) {
        //     System.out.print("[" + interval[0] + ", " + interval[1] + "]");
        // } 
        // System.out.println();

        int prevEnd = pq.poll()[1];
        int count = 0;
        while(!pq.isEmpty()) {
            int current[] = pq.poll();
            if(prevEnd <= current[0]) {
                prevEnd = current[1];
            } else {
                count++;
            prevEnd = Math.min(prevEnd, current[1]);
            }
        }
        return count;

        
    }
}
