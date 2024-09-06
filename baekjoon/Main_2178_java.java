package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // bfs
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;
                if(visited[nx][ny] || arr[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny});
                arr[nx][ny] = arr[x][y]+1;
                visited[nx][ny] = true;
            }
        }

        System.out.println(arr[N-1][M-1]);
    }
}
