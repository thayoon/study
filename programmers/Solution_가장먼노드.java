import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) { // 인접 리스트 초기화
            adj[e[0]-1].add(e[1]-1);
            adj[e[1]-1].add(e[0]-1);
        }
        
        // 거리 초기화
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0); // 0번 노드부터 시작
        
        while(!q.isEmpty()) {
            int v = q.poll();
            for (int next : adj[v]) {
                if(dist[next] == -1) { // 아직 방문하지 않았다면 갱신
                    dist[next] = dist[v] + 1;
                    q.offer(next);
                }
            }
        }
        
        // 최대 거리와 노드 개수 계산
        int max = 0;
        for(int i=0; i<n; i++) {
            if(dist[i] > max) {
                max = dist[i];
                answer = 1;
            }else if(dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}