package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if(str.charAt(j) == '0'){ // 전류가 통하는 경우
                    map[i][j] = true;

                    if(i == 0) {
                        q.offer(new int[] {i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        String ans = "NO";
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if(x == M-1) {
                ans = "YES";
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

        System.out.println(ans);
    }
}
