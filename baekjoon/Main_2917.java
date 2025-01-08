package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2917 {
    static int N, M, hx, hy, ex, ey;
    static int[][] dist;
    static Queue<int[]> tree;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        tree = new ArrayDeque<>();
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                dist[i][j] = 987654321;

                if(map[i][j] == 'V') {
                    hx = i;
                    hy = j;
                } else if(map[i][j] == 'J') {
                    ex = i;
                    ey = j;
                } else if(map[i][j] == '+') {
                    tree.offer(new int[] {i, j, 0});
                    dist[i][j] = 0;
                }
            }
        }

        calTreeDist();
        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[2], o1[2]));
        pq.offer(new int[] {hx, hy, dist[hx][hy]});
        boolean[][] visited = new boolean[N][M];
        visited[hx][hy] = true;
        int min = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if(min > d) min = d;
            if(x == ex && y == ey) return min;

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new int[] {nx, ny, dist[nx][ny]});
                }
            }
        }
        return 0;
    }

    private static void calTreeDist() {
        while(!tree.isEmpty()) {
            int[] now = tree.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if(d > dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && dist[nx][ny]>d+1) {
                    dist[nx][ny] = d+1;
                    tree.offer(new int[] {nx, ny, dist[nx][ny]});
                }
            }
        }
    }
}
