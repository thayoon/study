package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27375 {
    static int n, k, ans;
    static int[][] lesson;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;

        lesson = new int[n][3];
        visited = new boolean[5][11];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lesson[i][0] = Integer.parseInt(st.nextToken());
            lesson[i][1] = Integer.parseInt(st.nextToken());
            lesson[i][2] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(ans);
    }

    public static void backtracking(int cnt, int start) {
        if(cnt == k) {
            ans++;
            return;
        }

        for (int i = start; i < n; i++) {
            int w = lesson[i][0];
            int s = lesson[i][1];
            int e = lesson[i][2];

            if(w == 5) continue;

            boolean possible = true;
            for (int j = s; j <= e; j++) {
                if(visited[w][j]) {
                    possible = false;
                    break;
                }
            }

            if(possible) {
                for (int j = s; j <= e; j++) {
                    visited[w][j] = true;
                }

                backtracking(cnt+(e-s+1), i+1);

                for (int j = s; j <= e; j++) {
                    visited[w][j] = false;
                }
            }
        }
    }
}
