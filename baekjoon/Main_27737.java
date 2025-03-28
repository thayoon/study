package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_27737 {
    static int N, M, K;
    static boolean[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 0) {
                    map[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]) {
                    int cur = bfs(i, j);
                    cnt += (int) Math.ceil((double) cur/K);

                    if(cnt > M) break;
                }
            }
        }

        if(cnt > M || cnt == 0) {
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println("POSSIBLE");
            System.out.println(M-cnt);
        }

    }

    public static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        map[i][j] = false;

        int cnt = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]) {
                    map[nx][ny] = false;
                    q.offer(new int[] {nx, ny});
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
