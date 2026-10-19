class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList();
        for(int t: tickets)
            queue.offer(t);
        
        int ans = 0;
        while(!queue.isEmpty()) {
            if(ans == 0) {
                int done = 0;
                for(int i = 0;i < k && !queue.isEmpty();i++) {
                    int curr = queue.poll();
                    if(curr == 1) {
                        done++;
                    } else {
                        queue.offer(curr-1);
                    }

                }
                if(!queue.isEmpty()) {
                    int curr = queue.poll();
                    ans += (k+1);
                    if(curr == 1)
                        break;
                    
                    queue.offer(curr-1);
                    k -= done;
                }
            } else {
                int done = 0;
                int n = queue.size();
                for(int i = 0;i < n-1 && !queue.isEmpty();i++) {
                    int curr = queue.poll();
                    if(curr == 1) {
                        done++;
                    } else {
                        queue.offer(curr-1);
                    }

                }
                if(!queue.isEmpty()) {
                    int curr = queue.poll();
                    ans += n;
                    if(curr == 1)
                        break;
                    
                    queue.offer(curr-1);
                    k -= done;
                }
            }
        }

        return ans;
    }
}