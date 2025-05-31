package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_24390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(":");
        int sec = Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[sec+1][2];
        q.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        int[] btn = {10, 60, 600};

        int click = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int t = now[0];
            int start = now[1];
            int cnt = now[2];

            if(t == sec && start == 1) {
                click = cnt;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nt = t+btn[i];

                if(nt <= sec && !visited[nt][start]) {
                    visited[nt][start] = true;
                    q.offer(new int[] {nt, start, cnt+1});
                }
            }

            if(start == 0) { // 조리 중이 아닐 때 조리시작 버튼
                if(t == 0 && t+30 <= sec && !visited[30][1]) { // 0초라면 30초 추가 시작
                    visited[30][1] = true;
                    q.offer(new int[] {30, 1, cnt+1});
                }
                if(!visited[t][1]) { // 조리 시작
                    visited[t][1] = true;
                    q.offer(new int[] {t, 1, cnt+1});
                }
            } else { // 조리 중
                if(t+30 <= sec && !visited[t+30][1]) {
                    visited[t+30][1] = true;
                    q.offer(new int[] {t+30, 1, cnt+1});
                }
            }
        }

        System.out.println(click);
    }
}
