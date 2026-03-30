class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int[] course = prerequisites[i];
            map.get(course[0]).add(course[1]);
        }
        for(Integer key : map.keySet()) {
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, visited)) {
                return false;
            }
        }
        return true;
        
    }
    public boolean dfs(int course, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if(visited.contains(course)) { return false; }
        if(adj.get(course).isEmpty()) { return true; }
        visited.add(course);
        for(Integer n : adj.get(course)) {
            if(!dfs(n, adj, visited)) {
                return false;
            }
        }
        visited.remove(course);
        adj.put(course, new ArrayList<>());
        return true;
    }
}
