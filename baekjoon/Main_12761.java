package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        q.offer(new int[] {N, 0});
        visited[N] = true;

        int[] dx = {1, -1, A, -A, B, -B, A, B};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int move = now[1];

            if(cur == M) {
                System.out.println(move);
                break;
            }

            for (int i = 0; i < 8; i++) {
                int next = (i<6) ? cur+dx[i] : cur*dx[i];
                if(next>=0 && next<=100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, move+1});
                }
            }
        }
    }
}
