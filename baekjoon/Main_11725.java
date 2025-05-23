package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725 {
    static int N;
    static List<Integer>[] adj;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        adj = new List[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        parent = new int[N+1];
        parent[1] = 1;
        bfs();
//        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int next : adj[v]) {
                if(parent[next] == 0) {
                    parent[next] = v;
                    q.offer(next);
                }
            }
        }
    }

    public static void dfs(int v) {
        for(int next : adj[v]) {
            if(parent[next] == 0) {
                parent[next] = v;
                dfs(next);
            }
        }
    }
}
