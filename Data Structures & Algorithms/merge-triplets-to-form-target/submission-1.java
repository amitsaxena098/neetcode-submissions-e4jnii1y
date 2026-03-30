class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        List<Integer> indexes = new ArrayList<>();
        int i = 0;
        for(int[] triplet : triplets) {
            if(!(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2])) {
                indexes.add(i);
            }
            i++;
        }
        int[] res = new int[] {0, 0, 0};
        for(int m = 0; m < indexes.size(); m++) {
            res[0] = Math.max(res[0], triplets[indexes.get(m)][0]);
            res[1] = Math.max(res[1], triplets[indexes.get(m)][1]);
            res[2] = Math.max(res[2], triplets[indexes.get(m)][2]);
        }
        return (res[0] == target[0] && res[1] == target[1] && res[2] == target[2]);
    }
}
