package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            map[Y][X] = true;
        }

        int[] dx = {0, 1, 1, 0, -1, -1};
        // 홀수 번째 행 (0, 2, ...)
        int[] oy = {1, 0, -1, -1, -1, 0};
        // 짝수 번째 행
        int[] ey = {1, 1, 0, -1, 0, 1};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        int cnt = -1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if(x == N-1 && y == M-1) {
                cnt = d;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = x+dx[i];
                int ny = y;
                if(x%2 == 0) {
                    ny += oy[i];
                }else {
                    ny += ey[i];
                }

                if(nx>=0 && nx<N && ny>=0 && ny<M && !map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d+1});
                }
            }
        }

        System.out.println(cnt);

    }
}
