package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23747 {
    static int R, C;
    static char[][] map, vision;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine()); // 출발 좌표
        int HR = Integer.parseInt(st.nextToken())-1;
        int HC = Integer.parseInt(st.nextToken())-1;

        String log = br.readLine();

        vision = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(vision[i], '#');
        }

        for (int i = 0; i < log.length(); i++) {
            int now = log.charAt(i);
            int next = 4; // 이동 좌표
            if(now == 'W') {
                if(!visited[HR][HC]) {
                    bfs(HR, HC, map[HR][HC]); // 와드 설치
                }
            } else {
                switch (now) {
                    case 'U':
                        next = 0;
                        break;
                    case 'D':
                        next = 1;
                        break;
                    case 'L':
                        next = 2;
                        break;
                    case 'R':
                        next = 3;
                        break;
                }
                HR += dx[next];
                HC += dy[next];
            }
        }

        for (int j = 0; j < 5; j++) { // 마지막 위치 시야 확보
            int nx = HR+dx[j];
            int ny = HC+dy[j];
            if(nx>=0 && nx<R && ny>=0 && ny<C) {
                vision[nx][ny] = '.';
            }
        }

        for (char[] row : vision) {
            sb.append(row).append("\n");
        }
        System.out.print(sb);

    }

    public static void bfs(int r, int c, char w) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true; // 시작 위치 설정
        vision[r][c] = '.';

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && map[nx][ny] == w) {
                    visited[nx][ny] = true;
                    vision[nx][ny] = '.'; // 와드 설치
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
