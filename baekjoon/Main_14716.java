package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14716 {
    static int M, N;
    static boolean[][] map;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        map[i][j] = false;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 8; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny]) {
                    map[nx][ny] = false;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
