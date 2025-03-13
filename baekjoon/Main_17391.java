package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][M]; // 최소 이동 횟수 저장
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        q.offer(new int[] {0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int item = a[x][y];

            for (int m = 1; m <= item; m++) {
                if(x+m < N && dist[x+m][y] > dist[x][y] + 1) {
                    dist[x+m][y] = dist[x][y] + 1;
                    q.offer(new int[] {x+m, y});
                }
                if(y+m < M && dist[x][y+m] > dist[x][y] + 1) {
                    dist[x][y+m] = dist[x][y] + 1;
                    q.offer(new int[] {x, y+m});
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}
