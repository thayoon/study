package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2638 {
    static int N, M;
    static int[][] map;
    static boolean[][] air;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(true) {
            air = new boolean[N][M];

            checkOutsideAir(); // 외부 공기

            List<int[]> c = takeCheese(); // 외부 공기 접촉 치즈

            if(c.isEmpty()) break; // 외부 공기 접촉 치즈가 없다면 치즈가 모두 녹아 없어진것

            for(int[] d:c) { // 치즈 녹이기
                map[d[0]][d[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    private static List<int[]> takeCheese() {
        List<int[]> cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    int c = 0; // 외부 공기 접촉 횟수
                    for (int k = 0; k < 4; k++) {
                        if(c>=2) break;
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx>=0 && nx<N && ny>=0 && ny<M && air[nx][ny]) {
                            c++;
                        }
                    }

                    if(c>=2) {
                        cheese.add(new int[] {i, j}); // 외부 공기 접촉 치즈
                    }
                }
            }
        }
        return cheese;
    }

    private static void checkOutsideAir() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0}); // 모눈종이 맨 가장자리에는 치즈가 놓이지 않음 (=외부 공기)
        air[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int j = 0; j < 4; j++) {
                int nx = x+dx[j];
                int ny = y+dy[j];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !air[nx][ny] && map[nx][ny] == 0) {
                    air[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}