package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = Integer.MIN_VALUE;
        int area = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max); // 높이 최댓값
            }
        }

        for (int i = 0; i <= max ; i++) {
            visited = new boolean[N][N];    // 현재 높이 안전 지대 방문 처리
            int cnt = 0;    // 현재 높이 안전 영역
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(!visited[j][k] && map[j][k] > i) {
                        dfs(i, j, k);
                        cnt++;
                    }
                }
            }
            area = Math.max(area, cnt);
        }

        System.out.println(area);
    }

    /**
     * visited 처리
     * @param min : 현재 최소 높이
     * @param x : 현재 x 좌표
     * @param y : 현재 y 좌표
     */
    static private void dfs(int min, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny] <= min) continue;
            dfs(min, nx, ny);
        }
    }
}
