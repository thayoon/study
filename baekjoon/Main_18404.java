package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 987654321);
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.offer(new int[] {X, Y, 0});
        visited[X][Y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int move = now[2];

            if(map[r][c] > move) {
                map[r][c] = move;
            }

            for (int k = 0; k < 8; k++) {
                int nx = r+dx[k];
                int ny = c+dy[k];

                if(nx>0 && nx<=N && ny>0 && ny<=N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, move+1});
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(map[A][B]).append(" ");
        }

        System.out.println(sb);
    }
}
