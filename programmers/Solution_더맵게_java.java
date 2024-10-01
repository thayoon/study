import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() > 1) {
            int o1 = pq.poll();
            if(o1 >= K) {
                return cnt;
            }
            int o2 = pq.poll();
            
            int sco = o1 + (o2*2);
            
            pq.offer(sco);
            cnt++;
        }
        return pq.poll() >= K ? cnt : -1;
    }
}