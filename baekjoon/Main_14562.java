package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[201][301];
            Queue<int[]> q = new ArrayDeque<>();
            visited[S][T] = true;
            q.offer(new int[] {S, T, 0});

            int score = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int curS = now[0];
                int curT = now[1];
                int total = now[2];

                if(curS > curT) continue;

                if(curS == curT) {
                    score = total;
                    break;
                }
                // A
                int ns = curS*2;
                int nt = curT+3;
                if(ns < 201 && nt < 301 && !visited[ns][nt]) {
                    visited[ns][nt] = true;
                    q.offer(new int[] {ns, nt, total+1});
                }
                // B
                ns = curS+1;
                nt = curT;
                if(ns < 201 && !visited[ns][nt]) {
                    visited[ns][nt] = true;
                    q.offer(new int[] {ns, nt, total+1});
                }
            }

            sb.append(score).append("\n");
        }

        System.out.println(sb);
    }
}
