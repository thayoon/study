package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_24446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] depth = new int[N+1];
        Arrays.fill(depth, -1);
        q.offer(R);
        depth[R] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj[cur]) {
                if(depth[next] == -1) {
                    depth[next] = depth[cur] + 1;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);
    }
}
