package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1240 {
    static int N;
    static List<int[]>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[A].add(new int[]{B, d});
            adj[B].add(new int[]{A, d});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        q.offer(new int[] {start, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int d = now[1];

            if(cur == end) {
                return d;
            }

            for(int[] next:adj[cur]) {
                if(!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.offer(new int[]{next[0], d+next[1]});
                }
            }
        }
        return 0;
    }
}
