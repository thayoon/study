package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16457 {
    static int n, m, k, max;
    static int[][] skill;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = 0;

        skill = new int[m][k];
        visited = new boolean[101];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                skill[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);
        System.out.println(max);
    }

    public static void dfs(int cnt, int start) {
        if(cnt == n) {
            int q = 0;
            for (int i = 0; i < m; i++) {
                boolean v = true;
                for (int j = 0; j < k; j++) {
                    if (!visited[skill[i][j]]) {
                        v = false;
                        break;
                    }
                }
                if (v) q++;
            }
            max = Math.max(max, q);
            return;
        }

        for (int i = start; i <= n*2; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }

}
