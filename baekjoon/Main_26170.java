package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26170 {
    static int min;
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        visited[r][c] = true;
        dfs(r, c, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int r, int c, int apple, int move) {
        if(apple == 3) {
            min = Math.min(min, move);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = r+dx[k];
            int y = c+dy[k];

            if(x>=0 && x<5 && y>=0 && y<5 && !visited[x][y] && map[x][y] != -1) {
                visited[x][y] = true;
                if(map[x][y] == 1) {
                    dfs(x, y, apple+1, move+1);
                } else {
                    dfs(x, y, apple, move+1);
                }
                visited[x][y] = false;
            }
        }
    }
}
