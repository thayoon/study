package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if(map[x][y] == -1) {
                System.out.println("HaruHaru");
                return;
            }

            int nx = x+map[x][y];
            int ny = y+map[x][y];

            if(nx<N && !visited[nx][y]) {
                visited[nx][y] = true;
                q.offer(new int[] {nx, y});
            }
            if(ny<N && !visited[x][ny]) {
                visited[x][ny] = true;
                q.offer(new int[] {x, ny});
            }
        }

        System.out.println("Hing");
    }
}
