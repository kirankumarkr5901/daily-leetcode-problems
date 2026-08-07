class Solution {
    private int getDistance(int[] point) {
        return (point[0] * point[0]) + (point[1]*point[1]);
    }

    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        int[][] track = new int[len][3];
        for(int i = 0;i<len;i++) {
            track[i][0] = getDistance(points[i]);
            track[i][1] = points[i][0];
            track[i][2] = points[i][1];
        }
        Arrays.sort(track, (int[] a, int[] b) -> a[0] - b[0]);
        int[][] answer = new int[k][2];
        for(int i = 0;i<k;i++) {
            answer[i][0] = track[i][1];
            answer[i][1] = track[i][2];
        }
        return answer;
    }
}