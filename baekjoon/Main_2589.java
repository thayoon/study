package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    int len = bfs(i, j);
                    time = Math.max(time, len);
                }
            }
        }

        System.out.println(time);
    }

    public static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j, 0});
        visited[i][j] = true;

        int time = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cur = now[2];

            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur+1});
                    time = Math.max(time, cur+1);
                }
            }
        }

        return time;
    }
}
