package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        q.offer(new int[] {r, c, 0});
        visited[r][c] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int min = -1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int move = now[2];

            if(map[x][y] == 1) {
                min = move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<5 && ny>=0 && ny<5 && !visited[nx][ny] && map[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, move+1});
                }
            }
        }

        System.out.println(min);
    }
}
