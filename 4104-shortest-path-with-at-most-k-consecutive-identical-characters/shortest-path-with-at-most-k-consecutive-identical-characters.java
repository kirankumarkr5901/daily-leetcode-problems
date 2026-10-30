import java.util.*;

class Solution {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node;
        int count;
        long distance;

        State(int node, int count, long distance) {
            this.node = node;
            this.count = count;
            this.distance = distance;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from].add(new Edge(to, weight));
        }

        long[][] distance = new long[n][k + 1];

        for (long[] row : distance) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<State> minHeap =
                new PriorityQueue<>(Comparator.comparingLong(state -> state.distance));

        // Node 0's label has appeared once.
        distance[0][1] = 0;
        minHeap.offer(new State(0, 1, 0));

        while (!minHeap.isEmpty()) {
            State current = minHeap.poll();

            int node = current.node;
            int count = current.count;
            long currentDistance = current.distance;

            // Stale priority queue entry.
            if (currentDistance != distance[node][count]) {
                continue;
            }

            // The first target state removed from the heap is optimal.
            if (node == n - 1) {
                return (int) currentDistance;
            }

            for (Edge edge : graph[node]) {
                int nextNode = edge.to;

                int nextCount;

                if (labels.charAt(node) == labels.charAt(nextNode)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // More than k identical consecutive labels.
                if (nextCount > k) {
                    continue;
                }

                long nextDistance = currentDistance + edge.weight;

                if (nextDistance < distance[nextNode][nextCount]) {
                    distance[nextNode][nextCount] = nextDistance;

                    minHeap.offer(
                            new State(nextNode, nextCount, nextDistance)
                    );
                }
            }
        }

        return -1;
    }
}