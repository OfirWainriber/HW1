
public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        int n = m.length;
        int[] dist = new int[n];
        for (int k = 0; k < n; k++) {
            dist[k] = -1;
        }

        int[] queue = new int[n];
        int head = 0, tail = 0;

        dist[i] = 0;
        queue[tail++] = i;

        while (head < tail) {
            int curr = queue[head++];
            if (curr == j) {
                return dist[curr];
            }

            for (int next = 0; next < n; next++) {
                if (m[curr][next] == 1 && dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue[tail++] = next;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}}, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 1, 0}}, 0, 2)); // 2
    }
}
