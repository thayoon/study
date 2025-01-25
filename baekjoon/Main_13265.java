package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13265 {
    static int n;
    static List<Integer>[] adj;
    static int[] color;
    static boolean isBipartite;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n+1];
            color = new int[n+1];
            isBipartite = true;
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
                color[i] = 0; // 방문 전 정점의 색을 0으로 초기화
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                adj[y].add(x);
            }

            for (int i = 1; i < n+1; i++) {
                if(!isBipartite) break;

                if(color[i] == 0) {
                    bfs(i, 1);
                }
            }

            if(isBipartite) {
                sb.append("possible").append("\n");
            } else {
                sb.append("impossible").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void bfs(int start, int red) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = red;

        while(!q.isEmpty() && isBipartite) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if(color[next] == 0) { // 방문하지 않은 정점이라면
                    q.offer(next);
                    color[next] = color[cur]*-1; // 인접한 정점을 현재 정점과 반대 색으로
                } else if(color[next] == color[cur]) { // 인접 정점의 색이 같다면 이분 그래프가 아님
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
