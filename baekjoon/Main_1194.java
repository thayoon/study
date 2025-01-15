package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {
    static int N, M;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == '0') {
                    sr = i;
                    sc = j;
                }
            }
        }

        System.out.println(bfs(sr, sc));
    }

    public static int bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][64]; // 2^6 (= a, b, c, d, e, f)
        q.offer(new int[] {r, c, 0, 0});
        visited[r][c][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            int key = now[3];

            if(map[x][y] == '1') {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][key] && map[nx][ny] != '#') {
                    char cur = map[nx][ny];
                    if(cur >= 'a' && cur <= 'f') {  // 열쇠인 경우
                        int update = key | (1<<(cur-'a'));
                        visited[nx][ny][update] = true;
                        q.offer(new int[] {nx, ny, d+1, update});
                    } else if(cur >= 'A' && cur <= 'F') { // 문인 경우
                        if((key & (1<<(cur-'A'))) != 0) {
                            visited[nx][ny][key] = true;
                            q.offer(new int[] {nx, ny, d+1, key});
                        }
                    } else {
                        visited[nx][ny][key] = true;
                        q.offer(new int[] {nx, ny, d+1, key});
                    }
                }
            }
        }
        return -1;
    }
}
