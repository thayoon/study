package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_22868 {
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        List<Integer> route = new ArrayList<>();
        int StoE = bfs(S, E, route);

        visited = new boolean[N+1];
        for(int next : route) {
            visited[next] = true;
        }
        visited[S] = false;
        int EtoS = bfs(E, S, null);

        System.out.println(StoE+EtoS);
    }

    public static int bfs(int start, int end, List<Integer> route) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] path = new int[N+1];

        q.offer(new int[] {start, 0});
        visited[start] = true;
        path[start] = -1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int d = now[1];

            if(cur == end) {
                if(route != null) {
                    int cnt = end;
                    while(cnt != -1) {
                        route.add(cnt);
                        cnt = path[cnt];
                    }
                }

                return d;
            }

            for(int next:adj[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    path[next] = cur;
                    q.offer(new int[] {next, d+1});
                }
            }
        }

        return 0;
    }
}
