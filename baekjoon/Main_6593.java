package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] df = {0, 0, 0, 0, 1, -1};
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0, 0};

        while(true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()); // 빌딩 층 수
            int R = Integer.parseInt(st.nextToken()); // 한 층의 행
            int C = Integer.parseInt(st.nextToken()); // 한 층의 열

            if(L == 0 && R == 0 && C == 0) break; // 테스트 케이스 끝

            char[][][] map = new char[L][R][C];
            int[] start = new int[3]; // 시작 좌표

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);

                        if(map[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine(); // 각 층 사이 빈 줄 처리
            }

            Queue<int[]> q = new ArrayDeque<>();
            boolean[][][] visited = new boolean[L][R][C];
            visited[start[0]][start[1]][start[2]] = true;
            q.offer(new int[] {start[0], start[1], start[2], 0});
            int min = Integer.MAX_VALUE;

            while(!q.isEmpty()) {
                int[] now = q.poll();
                int f = now[0]; // 현재 층
                int x = now[1]; // 현재 행
                int y = now[2]; // 현재 열
                int time = now[3]; // 현재 시간

                if(map[f][x][y] == 'E') { // 도착
                    min = Math.min(min, time);
                    continue;
                }

                for (int i = 0; i < 6; i++) { // 동, 서, 남, 북, 상, 하 이동
                    int nf = f+df[i];
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nf>=0 && nf<L && nx>=0 && nx<R && ny>=0 && ny<C && !visited[nf][nx][ny] && map[nf][nx][ny] != '#') {
                        visited[nf][nx][ny] = true;
                        q.offer(new int[] {nf, nx, ny, time+1});
                    }
                }
            }

            if(min == Integer.MAX_VALUE) {
                sb.append("Trapped!\n");
            }else {
                sb.append("Escaped in ").append(min).append(" minute(s).\n");
            }
        }
        System.out.println(sb);
    }
}
