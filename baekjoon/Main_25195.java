package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_25195 {
    static int N;
    static List<Integer>[] adj;
    static boolean[] dfsVisited;
    static boolean[] fan;
    static boolean move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        adj = new ArrayList[N]; // 그래프 간선 정보
        fan = new boolean[N]; // 팬클럽 곰곰이 존재 위치
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adj[u].add(v);
        }

        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            fan[Integer.parseInt(st.nextToken())-1] = true;
        }

        // dfs
        dfsVisited = new boolean[N];
        dfs(0);
        System.out.println(move ? "yes" : "Yes");

        // bfs
        // System.out.println(bfs());

    }

    public static void dfs(int v) { // 384ms
        dfsVisited[v] = true; // 현재 정점 방문
        if(fan[v] || move) { // 팬클럽 곰곰이가 존재하거나 이미 이동 방법이 존재하는 경우 b.c
            return;
        }
        if(adj[v].size() == 0) { // 투어리스트 곰곰이의 여행이 종료된 경우
            move = true; // 이동 방법 존재
            return;
        }
        for(int next : adj[v]) { // 다음 이동 간선
            if(!dfsVisited[next] && !fan[next]) { // 아직 방문하지 않았고 팬클럽이 존재하지 않은 경우 탐색
                dfs(next);
            }
        }
    }

    public static String bfs() { // 432ms
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0); // 투어리스트 곰곰이의 여행은 1번 정점에서 출발
        boolean[] visited = new boolean[N];
        visited[0] = true;
        // 팬클럽 곰곰이를 만나게 된다면 "Yes"
        // 팬클럽 곰곰이를 만나지 않고 이동하는 방법이 존재한다면 "yes"
        String ans = "Yes";

        while(!q.isEmpty()) {
            int now = q.poll();

            if(fan[now]) { // 팬클럽 존재 다음 정점 이동
                continue;
            }

            if(adj[now].size() == 0) {
                // 끝 도달
                ans = "yes"; // 이동 경로 존재
                break;
            }

            for (int next : adj[now]) {
                if(!visited[next]) { // 아직 방문하지 않은 정점이라면 다음 정점 방문
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return ans;
    }
}
