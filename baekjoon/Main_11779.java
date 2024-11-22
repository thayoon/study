package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[A].add(new int[] {B, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 도착 도시

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] dist = new int[n+1]; // 최소 비용 배열
        Arrays.fill(dist, 987654321);
        dist[start] = 0;
        int[] city = new int[n+1]; // 경로 순서 배열
        city[start] = 0;
        pq.offer(new int[] {start, 0}); // 시작 도시, 비용
        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];

            if(!visited[cur]) {
                visited[cur] = true;
                for(int[] next: adj[cur]) {
                    if(dist[next[0]] > dist[cur]+next[1]) {
                        dist[next[0]] = dist[cur]+next[1];
                        pq.offer(new int[] {next[0], dist[next[0]]});
                        city[next[0]] = cur;
                    }
                }
            }
        }

        sb.append(dist[end]).append("\n"); // 최소 비용
        int cnt = end; // 경로 찾기
        List<Integer> route = new ArrayList<>();
        while(cnt != 0) {
            route.add(cnt); // 경로 추가
            cnt = city[cnt]; // 다음 경로 번호
        }
        sb.append(route.size()).append("\n"); // 도시 수
        for (int i = route.size()-1; i >= 0; i--) {
            sb.append(route.get(i)).append(" "); // 경로
        }

        System.out.println(sb.toString());
    }
}
