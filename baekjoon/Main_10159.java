package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10159 {
    static int N, M;
    static List<Integer>[] adj, radj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        radj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }

        boolean[][] wigth = new boolean[N+1][N+1]; // 플로이드-와샬
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int hw = Integer.parseInt(st.nextToken());
            int lw = Integer.parseInt(st.nextToken());

            adj[hw].add(lw);
            radj[lw].add(hw);
            wigth[hw][lw] = true;
        }

        // dfs
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            int heavy = dfs(i, adj);
            visited = new boolean[N+1];
            int light = dfs(i, radj);

            sb.append(N-1-(heavy+light)).append("\n");
        }
        // ===========

        // 플로이드-와샬
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(wigth[i][k] && wigth[k][j]) wigth[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = N-1;
            for (int j = 1; j <= N; j++) {
                if(wigth[i][j] || wigth[j][i]) cnt--;
            }
            sb.append(cnt).append("\n");
        }
        // ===========

        System.out.println(sb);
    }

    public static int dfs(int cur, List<Integer>[] list) {
        visited[cur] = true;
        int cnt = 0;

        for(int next: list[cur]) {
            if(!visited[next]) {
                cnt += dfs(next, list)+1;
            }
        }
        return cnt;
    }
}
