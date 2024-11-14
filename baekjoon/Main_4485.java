package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int[] dx = {0, 1, 0, -1}; // 상하좌우
        int[] dy = {1, 0, -1, 0};

        int tc = 0; // 테스트 케이스 번호

        while(true) {
            tc++; // 테스트 케이스 추가
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            int[][] map = new int[N][N]; // 동굴
            int[][] dist = new int[N][N]; // 최소 비용 저장

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = 987654321; // 최대 비용으로 초기화
                }
            }

            // 최소 비용 오름차순 우선 순위
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

            pq.offer(new int[] {0, 0, map[0][0]});

            while(!pq.isEmpty()) {
                int[] now = pq.poll();
                int x = now[0];
                int y = now[1];
                int rupee = now[2]; // 누적 도둑 루피

                for (int i = 0; i < 4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(dist[nx][ny] > rupee + map[nx][ny]) { // 기존 비용보다 작다면 dist 갱신, 큐 값 추가
                        dist[nx][ny] = rupee + map[nx][ny];
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    }
                }
            }

            sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
