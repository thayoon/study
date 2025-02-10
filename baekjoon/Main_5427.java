package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427 {
    static int w, h, time;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> fire;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            fire = new ArrayDeque<>();

            int r = 0;
            int c = 0;
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);

                    if(map[i][j] == '@') {
                        r = i;
                        c = j;
                    }
                    if(map[i][j] == '*') {
                        fire.offer(new int[] {i, j});
                    }
                }
            }

            sb.append(bfs(r, c) ? time : "IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c, 0});
        visited[r][c] = true;

        time = 0;
        while(!q.isEmpty()) {
            int fsize = fire.size();
            for (int i = 0; i < fsize; i++) {
                int[] f = fire.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = f[0]+dx[j];
                    int ny = f[1]+dy[j];

                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        fire.offer(new int[] {nx, ny});
                    }
                }
            }

            int qsize = q.size();
            for (int s = 0; s < qsize; s++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                int cur = now[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
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
