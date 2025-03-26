package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18243 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] adj = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(adj[i], 7);
            adj[i][i] = 0;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A][B] = 1;
            adj[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(adj[i][j] > 6) {
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");
    }
}
