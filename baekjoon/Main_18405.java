package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[3] == o2[3]) { // 시간 기준 정렬
                return Integer.compare(o1[2], o2[2]); // 시간이 같다면 낮은 바이러스 순서대로 정렬
            }
            return Integer.compare(o1[3], o2[3]);
        });
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] <= K) {
                    pq.offer(new int[] {i, j, map[i][j], 0});
                    visited[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 바이러스 시간
        int ex = Integer.parseInt(st.nextToken())-1; // 찾고자 하는 위치
        int ey = Integer.parseInt(st.nextToken())-1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int time = 0; // 현재 시간
        while(!pq.isEmpty()) {
            int size = pq.size(); // 현재 시간의 바이러스 크기
            if(time == S) break; // 현재 시간이 바이러스 시간과 같다면 종료
            time++;
            for (int i = 0; i < size; i++) {
                int[] now = pq.poll();
                int x = now[0];
                int y = now[1];
                int virus = now[2];
                int sec = now[3];

                for (int j = 0; j < 4; j++) {
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
                        // 낮은 바이러스 순서대로 진행하기 때문에 방문체크만 진행하면 됨
                        visited[nx][ny] = true;
                        map[nx][ny] = virus;
                        pq.offer(new int[]{nx, ny, map[nx][ny], sec+1});
                    }
                }
            }
        }

        System.out.println(map[ex][ey]);
    }
}
