package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1245 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean top;
    // 좌상 상 우상 좌 우 좌하 하 우하
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    top = true;
                    dfs(i, j);
                    if(top) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<M) {
                if(map[nx][ny] > map[x][y]) { // 산봉우리 X
                    top = false;
                } else if (!visited[nx][ny] && map[nx][ny] == map[x][y]) { // 아직 방문하지 않았고 주변 높이가 같은 경우 dfs탐색
                    dfs(nx, ny);
                }
            }
        }
    }
}
