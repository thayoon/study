package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_2665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if(str.charAt(j) == '0') {
                    // 검은 방인 경우 true
                    map[i][j] = true;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        int[][] dist = new int[n][n]; // 벽 부순 횟수
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 987654321);
        }
        pq.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;

        // 이동 방향
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0]; // x 좌표
            int y = now[1]; // y 좌표
            int wall = now[2]; // 벽 부순 횟수

            if(x == n-1 && y == n-1) { // 끝방 도착
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n) {
                    if(map[nx][ny] && dist[nx][ny] > wall+1) { // 검은 방인 경우
                        dist[nx][ny] = wall+1;
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    }else if(!map[nx][ny] && dist[nx][ny] > wall) { // 흰 방인 경우
                        dist[nx][ny] = wall;
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    }
                }
            }
        }

        System.out.println(dist[n-1][n-1]);
    }
}
