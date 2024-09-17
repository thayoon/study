package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
    static int N;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        int M = Integer.parseInt(st.nextToken());   // 간선 개수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점

        arr = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[begin][end] = 1;
            arr[end][begin] = 1;

        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int v) {
        System.out.print(v+" ");
        visited[v] = true;

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && arr[v][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now+" ");

            for (int i = 1; i <= N; i++) {
                if(!visited[i] && arr[now][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
