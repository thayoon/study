package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도착지
        int M = Integer.parseInt(st.nextToken()); // 길

        List<int[]>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());
            int Ci = Integer.parseInt(st.nextToken());

            adj[Ai].add(new int[] {Bi, Ci});
            adj[Bi].add(new int[] {Ai, Ci});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        pq.offer(new int[] {1, 0});
        dist[1] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];
            int cow = now[1];

            if(dist[cur] < cow) continue;
            if(cur == N) break;

            for(int[] next : adj[cur]) {
                if(dist[next[0]] > dist[cur] + next[1]) {
                    dist[next[0]] = dist[cur] + next[1];
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }

        System.out.println(dist[N]);
    }
}
