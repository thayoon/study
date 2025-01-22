package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303 {
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

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int white = 0;
        int blue = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'W' && !visited[i][j]) {
                    white += Math.pow(bfs(i, j, 'W'), 2);
                } else if(map[i][j] == 'B' && !visited[i][j]) {
                    blue += Math.pow(bfs(i, j, 'B'), 2);
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    public static int bfs(int i, int j, char team) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[] {i, j});

        int power = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] == team) {
                    visited[nx][ny] = true;
                    power++;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
        return power;
    }
}
