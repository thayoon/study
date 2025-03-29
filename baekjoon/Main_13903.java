package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[R][C];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(i == 0 && now == 1) {
                    q.offer(new int[] {i, j, 0});
                } else if(now == 1) {
                    map[i][j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        int[] dx = new int[N];
        int[] dy = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dx[i] = Integer.parseInt(st.nextToken());
            dy[i] = Integer.parseInt(st.nextToken());
        }

        int walk = 987654321;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if (x == R-1) {
                walk = Math.min(d, walk);
            }

            for (int i = 0; i < N; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]) {
                    map[nx][ny] = false;
                    q.offer(new int[] {nx, ny, d+1});
                }
            }
        }

        System.out.println(walk == 987654321 ? -1 : walk);

    }
}
