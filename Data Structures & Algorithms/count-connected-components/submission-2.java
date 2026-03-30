class Solution {
    public int countComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] cords : edges) {
            if(map.containsKey(cords[0])) {
                map.get(cords[0]).add(cords[1]);
            } else {
                map.put(cords[0], new ArrayList<>(Arrays.asList(cords[1])));
            }
            if(map.containsKey(cords[1])) {
                map.get(cords[1]).add(cords[0]);
            } else {
                map.put(cords[1], new ArrayList(Arrays.asList(cords[0])));
            }
        }
        
        int count = 0;
        for(int key: map.keySet()) {
            System.out.println("key=" + key + ", list="+map.get(key));
            if(!visited[key]) {
                bfs(map, visited, key);
                count++;
            }
        }
        if(n > map.size()) {
            return count + (n - map.size());
        }
        return count;

    }

    public void bfs(Map<Integer, List<Integer>> map, boolean[] visited, int cord) {
        Deque<Integer> deq = new ArrayDeque<>();
        deq.offerLast(cord);
        while(!deq.isEmpty()) {
            int cord2 = deq.pollFirst();
            if(!visited[cord2]) {
                visited[cord2] = true;
                for(Integer ngh : map.get(cord2))  {
                    deq.offerLast(ngh);
                }
            }
        }
    }
}
