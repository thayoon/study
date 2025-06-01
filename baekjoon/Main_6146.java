package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken()) + 500;
        int Y = Integer.parseInt(st.nextToken()) + 500;
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[1001][1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) + 500;
            int B = Integer.parseInt(st.nextToken()) + 500;

            map[A][B] = true;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {500, 500, 0});
        map[500][500] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if(x == X && y == Y) {
                System.out.println(d);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(Math.abs(nx) <= 1001 && Math.abs(ny) <= 1001 && !map[nx][ny]) {
                    map[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d+1});
                }
            }
        }
    }
}
