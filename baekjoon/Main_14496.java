package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = true;
            map[y][x] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.offer(new int[] {a, 0});
        visited[a] = true;

        int cnt = -1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int c = now[1];

            if(x == b) {
                cnt = c;
                break;
            }

            for (int i = 0; i < N; i++) {
                if(i != x && !visited[i] && map[x][i]) {
                    visited[i] = true;
                    q.offer(new int[] {i, c+1});
                }
            }
        }

        System.out.println(cnt);
    }
}
