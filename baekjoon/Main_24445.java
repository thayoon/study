package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            adj[i].sort(Collections.reverseOrder());
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[N+1];
        q.offer(R);
        int cnt = 1;
        visited[R] = cnt;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : adj[now]) {
                if(visited[next] == 0) {
                    visited[next] = ++cnt;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }
}
