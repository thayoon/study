package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18126 {
    static int N;
    static long max;
    static List<int[]>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        max = 0;
        adj = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new int[] {B, C});
            adj[B].add(new int[] {A, C});
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(max);
    }

    public static void dfs(int cur, long move) {
        if(max < move) max = move;

        for(int[] next : adj[cur]) {
            if(!visited[next[0]]) {
                visited[next[0]] = true;
                dfs(next[0], move+next[1]);
                visited[next[0]] = false;
            }
        }
    }
}
