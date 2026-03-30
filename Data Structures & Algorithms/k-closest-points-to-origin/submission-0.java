class Points implements Comparable<Points> {
    int x;
    int y;
    Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getx() { return this.x; }
    public int gety() { return this.y; }
    @Override
    public int compareTo(Points otherPoints) {
        double thisDistance = Math.sqrt((this.x * this.x) + (this.y * this.y));
        double otherDistance = Math.sqrt((otherPoints.x * otherPoints.x) + (otherPoints.y * otherPoints.y));
        if( thisDistance < otherDistance) { return -1; }
        else if(thisDistance == otherDistance) { return 0; }
        else { return 1; }
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < points.length; i++) {
            Points p = new Points(points[i][0], points[i][1]);
            pq.offer(p);
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()) {
            Points p = pq.poll();
            res[index][0] = p.getx();
            res[index][1] = p.gety();
            index++;
        }
        return res;
    }
}
