package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 마을 수
        int E = Integer.parseInt(st.nextToken()); // 도로 수
        int INF = 100000000;
        int[][] adj = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(adj[i], INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken()); // a번 마을에서 b번 마을로 가는 거리 c

            adj[a][b] = c;
        }

        // Floyd Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                if(i == k) continue;
                for (int j = 0; j < V; j++) {
                    if(i==j || j==k) continue;
                    adj[i][j] = Math.min(adj[i][k]+adj[k][j], adj[i][j]);
                }
            }
        }

        int min = INF;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i == j || adj[i][j] == INF || adj[j][i] == INF) continue;
                // adj[i][j], adj[j][i] != INF 라면, i->j, j->i 경로 존재
                min = Math.min(min, adj[i][j]+adj[j][i]); // 최소 사이클 도로 길이 합
            }
        }
        min = (min == INF) ? -1 : min;
        System.out.println(min);
    }
}
