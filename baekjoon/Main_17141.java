package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17141 {
    static int N, M, max;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> virus;
    static boolean[] v;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    virus.add(new int[] {i, j});
                }
            }
        }
        v = new boolean[virus.size()];
        max = Integer.MAX_VALUE;
        comb(0, 0);
        
        System.out.println(max == Integer.MAX_VALUE ? -1 : max);
    }
    public static void comb(int start, int cnt) {
        if(cnt == M) {
            int time = bfs();
            if(time != -1 && max>time) {
                max = time;
            }
            return;
        }

        for (int i = start; i < v.length; i++) {
            v[i] = true;
            comb(i+1,cnt+1);
            v[i] = false;
        }
    }
    public static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        for (int i = 0; i < v.length; i++) {
            if(v[i]) {
                q.offer(new int[] {virus.get(i)[0], virus.get(i)[1], 0});
                visited[virus.get(i)[0]][virus.get(i)[1]] = true;
            }
        }

        int t = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int time = now[2];

            t = Math.max(t, time);

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny, time+1});
                    visited[nx][ny] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !visited[i][j]) return -1;
            }
        }

        return t;
    }
}
