package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map = new int[101];
        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u] = v;
        }

        // bfs
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        q.offer(new int[] {1, 0}); // 현재 위치, 이동 수
        visited[1] = true;

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0]; // 현재 위치
            int cnt = now[1]; // 현재 이동 수

            if(cnt > min) continue; // 현재 이동 수가 현재 최소값보다 크다면 continue
            if(cur == 100) { // 도착
                min = Math.min(min, cnt); // 최솟값 갱신
                continue;
            }

            for (int i = 1; i <= 6; i++) { // 1~6 주사위 이동
                if(cur+i <= 100 && !visited[cur+i]) {
                    visited[cur+i] = true;
                    if(map[cur+i] != 0) { // 다음 좌표가 사다리거나 뱀인 경우
                        q.offer(new int[] {map[cur+i], cnt+1});
                    } else {
                        q.offer(new int[] {cur+i, cnt+1});
                    }
                }
            }
        }

        System.out.println(min);

    }
}
