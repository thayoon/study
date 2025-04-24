package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_21937 {
    static int N;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[B].add(A);
        }

        int X = Integer.parseInt(br.readLine());
        System.out.println(bfs(X));
    }

    public static int bfs(int X) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.offer(X);
        visited[X] = true;

        int work = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next: adj[now]) {
                if(!visited[next]) {
                    work++;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

        return work;
    }
}
