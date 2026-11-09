import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {endTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            // 1. Free servers that have completed their request
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }

            // 2. No server available -> drop request
            if (available.isEmpty()) {
                continue;
            }

            // 3. Request i prefers server i % k
            int preferred = i % k;

            Integer serverIndex = available.ceiling(preferred);

            // If no server >= preferred, wrap around
            if (serverIndex == null) {
                serverIndex = available.first();
            }

            // 4. Assign request
            available.remove(serverIndex);
            count[serverIndex]++;

            int endTime = arrival[i] + load[i];

            busy.offer(new int[]{endTime, serverIndex});
        }

        // Find maximum handled requests
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}