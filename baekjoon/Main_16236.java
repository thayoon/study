package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236 {
    static int N, r, c, size, eat;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine()); // 공간 크기
        map = new int[N][N];    // 공간
        r = 0; // 아기 상어 현재 위치
        c = 0;
        size = 2; // 아기 상어 크기
        eat = 0; // 아기 상어가 먹은 물고기 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    // 아기 상어 위치
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            int[] fish = bfs(); // 최소 이동 먹이 찾기
            if(fish == null) break; // 먹이가 없다면 엄마 상어 도움 요청 = 종료

            time += fish[0];
            r = fish[1]; // 다음 상어 위치
            c = fish[2];
            map[fish[1]][fish[2]] = 0; // 먹었기 떄문에 빈 칸으로

            if(++eat == size) { // 아기 상어 성장 여부
                size++; // 성장한다면 물고기 먹은 수 초기화
                eat = 0;
            }
        }

        System.out.println(time);
    }

    public static int[] bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N]; // 방문 처리 배열
        visited[r][c] = true;
        q.offer(new int[] {r, c, 0}); // 위치, 이동 시간

        PriorityQueue<int[]> fish = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) {
                if(o1[1] == o2[1]) {
                    return Integer.compare(o1[2], o2[2]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int min = Integer.MAX_VALUE; // 최소 이동시간
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];

            if(min < d) continue; // 최소 이동시간보다 크다면 다음 좌표
            if(map[x][y] > 0 && map[x][y] < size) { // 먹이라면
                min = d; // 최소 이동시간 갱신
                fish.offer(new int[] {d, x, y}); // 먹이 우선순위 큐 삽입
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d+1});
                }
            }
        }
        // 먹이가 없다면 null 반환
        if(fish.isEmpty()) return null;

        return fish.poll();
    }
}
