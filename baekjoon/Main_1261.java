package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int N = Integer.parseInt(st.nextToken()); // 세로 크기

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = str.charAt(j)-'0';
                if(num == 0) map[i][j] = true; // 빈 방인 경우 true
            }
        }

        // 이동 방향
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        // 최소 벽 부수기 값 초기화
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], 987654321);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.offer(new int[] {0, 0, 0}); // 0, 0 시작
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0]; // 현재 위치
            int y = now[1];
            int wall = now[2]; // 부순 벽 수

            if(x==N-1 && y==M-1) break; // 도착

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    if(map[nx][ny] && dist[nx][ny] > wall) {
                        // 빈 방인 경우
                        dist[nx][ny] = wall; // 부순 벽 개수 갱신
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    } else if(!map[nx][ny] && dist[nx][ny] > wall+1) {
                        // 벽인 경우
                        dist[nx][ny] = wall+1; // 부순 벽 개수 갱신
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    }
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}
