package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11123 {
    static int H, W;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new boolean[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    if(str.charAt(j) == '#') {
                        map[i][j] = true;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<H && ny>=0 && ny<W && !visited[nx][ny] && map[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
