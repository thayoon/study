package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int X = Integer.parseInt(br.readLine());

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, map[0][0]});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int color = now[2];

            if(x == N-1 && y == M-1) {
                System.out.println("ALIVE");
                return;
            }

            for (int dx = -X; dx <= X; dx++) {
                for (int dy = -X; dy <= X; dy++) {
                    if (Math.abs(dx) + Math.abs(dy) > X) continue;
                    int nx = x + dx;
                    int ny = y + dy;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] != color) continue;

                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, color});
                }
            }

        }

        System.out.println("DEAD");
    }
}
