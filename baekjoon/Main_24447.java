package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_24447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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

        long[] depth = new long[N+1];
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
            depth[i] = -1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        long[] time = new long[N+1];
        q.offer(R);
        int cnt = 1;
        time[R] = cnt++;
        depth[R] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj[cur]) {
                if(depth[next] == -1) {
                    time[next] = cnt++;
                    depth[next] = depth[cur]+1;
                    q.offer(next);
                }
            }
        }

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += depth[i]*time[i];
        }

        System.out.println(sum);
    }
}
