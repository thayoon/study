package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수
        int INF = 10000001;
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], INF); // 비용 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1; // 출발 도시
            int b = Integer.parseInt(st.nextToken())-1; // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            adj[a][b] = Math.min(adj[a][b], c);
        }

        // Floyd Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if(i==k) continue;
                for (int j = 0; j < n; j++) {
                    if(i==j || k==j) continue;
                    adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(adj[i][j] == INF) sb.append(0).append(" ");
                else sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
