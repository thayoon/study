package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17142 {
    static int N, M, min, empty;
    static int[][] map;
    static List<int[]> virus;
    static int[] v;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new ArrayList<>();
        min = Integer.MAX_VALUE;
        empty = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                } else if(map[i][j] == 0) {
                    empty++;
                }
            }
        }

        if(empty == 0) {
            // 빈 공간이 없다면
            System.out.println(0);
        } else {
            // vCm
            v = new int[M];
            comb(0, 0);

            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }
    public static void comb(int start, int cnt) {
        if(cnt == M) {
            int time = bfs();
            if(time != -1) {
                min = Math.min(min, time);
            }
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            v[cnt] = i;
            comb(i+1, cnt+1);
        }
    }

    public static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            int x = virus.get(v[i])[0];
            int y = virus.get(v[i])[1];
            q.offer(new int[]{x, y, 0});
            visited[x][y] = true;
        }

        int end = 0;
        int zero = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int time = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] != 1) {
                    if(map[nx][ny] == 0) {
                        // 빈 칸인 경우 바이러스 전염 + 시간 추가
                        zero++;
                        q.offer(new int[] {nx, ny, time+1});
                        end = Math.max(end, time+1);
                        visited[nx][ny] = true;
                    } else {
                        // 다른 비활성 바이러스인 경우 -> 활성 바이러스로 변경
                        q.offer(new int[] {nx, ny, time+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if(zero == empty) return end;
        else return -1;
    }
}
