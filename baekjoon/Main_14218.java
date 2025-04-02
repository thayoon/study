package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14218 {
    static int n, m;
    static List<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            adj[a].add(b);
            adj[b].add(a);
        }


        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            adj[a].add(b);
            adj[b].add(a);

            bfs();
        }

        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        for(int n: adj[0]) {
            q.offer(new int[] {n, 1});
            dist[n] = 1;
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int d = now[1];

            if(dist[cur] < d) continue;

            for(int next : adj[cur]) {
                if(dist[next] == -1 || dist[next] > d+1) {
                    q.offer(new int[] {next, d+1});
                    dist[next] = d+1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(dist[i]).append(" ");
        }
        sb.append("\n");
    }
}
