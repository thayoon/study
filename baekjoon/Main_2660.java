package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] adj = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(adj[i], 987654321);
            adj[i][i] = 0;
        }

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;

            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }

        int min = 987654321;
        List<Integer> candidate = new ArrayList<>();

        for (int i = 1; i < n+1; i++) {
            int max = 0;
            for (int j = 1; j < n+1; j++) {
                max = Math.max(max, adj[i][j]);
            }

            if(min > max) {
                min = max;
                candidate.clear();
                candidate.add(i);
            } else if (min == max) {
                candidate.add(i);
            }
        }

        sb.append(min).append(" ").append(candidate.size()).append("\n");
        for (int c : candidate) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
