package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    static int R, C, time;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        Queue<int[]> F = new ArrayDeque<>();
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'J') {
                    visited[i][j] = true;
                    q.offer(new int[] {i, j, 0});
                }
                if(map[i][j] == 'F') {
                    F.offer(new int[] {i, j});
                }
            }
        }
        time = 0;
        System.out.println(bfs(q, F) ? time : "IMPOSSIBLE");
    }

    public static boolean bfs(Queue<int[]> q, Queue<int[]> F) {
        while(!q.isEmpty()) {
            int fire = F.size();
            for (int i = 0; i < fire; i++) {
                int[] now = F.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];

                    if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        F.offer(new int[] {nx, ny});
                    }
                }
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                int cur = now[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx<0 || nx>=R || ny<0 || ny>=C) {
                        time = cur+1;
                        return true;
                    }
                    if(!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, cur+1});
                    }
                }
            }
        }

        return false;
    }
}
