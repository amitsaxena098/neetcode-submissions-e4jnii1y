class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> {
            if(first[0] != second[0]) {
                return Integer.compare(first[0], second[0]);
            }
            return Integer.compare(first[1], second[1]);
        });

        for(int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> res = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty()) {
            int[] currentInterval = pq.poll();
            System.out.println(currentInterval[0] + ", " + currentInterval[1]);

            while(!pq.isEmpty() && currentInterval[1] >= pq.peek()[0]) {
            System.out.println(pq.peek()[0] + ", " + pq.peek()[1]);

                currentInterval[1] = Math.max(pq.peek()[1], currentInterval[1]);
                pq.poll();
            }

            res.add(currentInterval);

        }
        return res.toArray(new int[res.size()][]);
        
    }
}
