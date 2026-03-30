class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] deg = new int[numCourses];
        Arrays.fill(deg, 0);
        for(int[] cords : prerequisites) {
            deg[cords[0]]++;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] cords : prerequisites) {
            adj.get(cords[1]).add(cords[0]);
        }

        int[] res = new int[numCourses];
        int index = 0;
        int i = 0;
        while(true) {
            if(index >= numCourses || i >= numCourses) { break; }
            if(deg[i] == 0) {
                res[index] = i;
                index++;
                for(Integer n : adj.get(i)) {
                    deg[n]--;
                }
                deg[i] = -1;
                i = 0;
            } else {
                i++;
            }
        }
        if(index < numCourses-1) {
            return new int[] {};
        }
        return res;

    }
}
