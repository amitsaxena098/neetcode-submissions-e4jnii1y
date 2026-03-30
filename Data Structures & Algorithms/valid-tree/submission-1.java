class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer,Integer> parent = new HashMap<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            if(adj.containsKey(edge[0])) {
                adj.get(edge[0]).add(edge[1]);
            } else {
                adj.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            }
            if(adj.containsKey(edge[1])) {
                adj.get(edge[1]).add(edge[0]);
            } else {
                adj.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
            }
        }
        Deque<Integer> deq = new ArrayDeque<>();
        deq.offerLast(0);
        parent.put(0, -1);
        int count = 0;
        while(!deq.isEmpty()) {
            int node = deq.pollFirst(); 
            visited[node] = true;
            count++;
            List<Integer> neighbors = adj.containsKey(node) ? adj.get(node) : List.of();
            for(Integer neighbor : neighbors) {
                if(!visited[neighbor]) {
                    deq.offerLast(neighbor);
                    parent.put(neighbor, node);
                } else {
                    if(neighbor != parent.get(node)) {
                        return false;
                    }
                }
            }
        }
        if(count < n) return false;
        return true;
        
    }
}
