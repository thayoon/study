package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14938 {
    static int n, m;
    static List<int[]>[] adj;
    static int[] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 지역 수
        m = Integer.parseInt(st.nextToken()); // 수색범위
        int r = Integer.parseInt(st.nextToken()); // 길 개수

        item = new int[n]; // 아이템 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[n]; // 인접 리스트
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, l});
            adj[b].add(new int[] {a, l});
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        System.out.println(max);
    }

    public static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, 987654321);
        boolean[] visited = new boolean[n];
        pq.offer(new int[] {start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];

            if(!visited[cur]) {
                visited[cur] = true;

                for(int[] next : adj[cur]) {
                    if(dist[next[0]] > dist[cur] + next[1]) {
                        dist[next[0]] = dist[cur] + next[1];
                        pq.offer(new int[] {next[0], dist[next[0]]});
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 최소 거리가 수색범위 이하라면 아이템 획득
            if(dist[i] <= m) result += item[i];
        }

        return result;
    }
}
