package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238 {
    static int N, M, X;
    static List<int[]>[] adj, radj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생/마을 수
        M = Integer.parseInt(st.nextToken()); // 단방향 도로 수
        X = Integer.parseInt(st.nextToken())-1; // 파티 마을
        adj = new ArrayList[N]; // N->X
        radj = new ArrayList[N]; // X->N
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int T = Integer.parseInt(st.nextToken());

            adj[A].add(new int[] {B, T});
            radj[B].add(new int[] {A, T});
        }

        int[] distX = dijkstra(adj); // N->X
        int[] distN = dijkstra(radj); // X->N

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, distX[i]+distN[i]);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(List<int[]>[] list) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, 987654321);

        pq.offer(new int[] {X, 0});
        dist[X] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];

            if(!visited[cur]) {
                visited[cur] = true;

                for(int[] next: list[cur]) {
                    if(dist[next[0]] > dist[cur]+next[1]) {
                        dist[next[0]] = dist[cur]+next[1];
                        pq.offer(new int[] {next[0], dist[next[0]]});
                    }
                }
            }
        }

        return dist;
    }
}
