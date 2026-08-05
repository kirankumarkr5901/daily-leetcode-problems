class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0;i<n;i++) {
            List<Integer> list = new ArrayList();
            graph.add(list);
        }

        for(int[] invok: invocations) {
            int parent = invok[0];
            int child = invok[1];
            graph.get(parent).add(child);
        }

        boolean[] bug = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.add(k);
        bug[k] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next: graph.get(current)) {
                if(!bug[next]) {
                    bug[next] = true;
                    queue.add(next);
                }
            }
        }
        List<Integer> answer = new ArrayList();
        for(int[] invok: invocations) {
            int parent = invok[0];
            int child = invok[1];
            if(!bug[parent] && bug[child]) {
                for(int i = 0;i<n;i++) {
                    answer.add(i);
                }
                return answer;
            }
        }

        for(int i = 0;i<n;i++) {
            if(!bug[i]) {
                answer.add(i);
            }
        }
        return answer;
    }
}