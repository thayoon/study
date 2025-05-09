package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_31871 {
    static int N, max;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        adj = new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(u == v) continue;
            if(adj[u][v] < d) adj[u][v] = d;
        }

        max = -1;
        visited = new boolean[N+1];
        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int cnt, int v, int d) {
        if(cnt == N) {
            if(adj[v][0] == 0) return;
            max = Math.max(max, d+adj[v][0]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && i != v && adj[v][i] > 0) {
                visited[i] = true;
                dfs(cnt+1, i, d+adj[v][i]);
                visited[i] = false;
            }
        }
    }
}
