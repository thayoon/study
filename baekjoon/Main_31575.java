package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if(x == M-1 && y == N-1) {
                System.out.println("Yes");
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println("No");

    }
}
