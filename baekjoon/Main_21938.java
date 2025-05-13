package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21938 {
    static int N, M, T;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                map[i][j] = (R+G+B)/3;
            }
        }

        T = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] >= T && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[] {i, j});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny] >= T) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
