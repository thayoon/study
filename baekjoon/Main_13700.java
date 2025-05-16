package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 건물 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 위치 금은방
        int D = Integer.parseInt(st.nextToken()); // 도착지
        int F = Integer.parseInt(st.nextToken()); // 전방 +F
        int B = Integer.parseInt(st.nextToken()); // 후방 -B
        int K = Integer.parseInt(st.nextToken()); // 경찰서 개수

        boolean[] map = new boolean[N+1];
        if (K > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int I = Integer.parseInt(st.nextToken());
                if (I <= N) {
                    map[I] = true;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {S, 0});
        map[S] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int X = now[0];
            int move = now[1];

            if(X == D) {
                System.out.println(move);
                return;
            }

            if(X-B >= 1 && !map[X-B]) {
                map[X-B] = true;
                q.offer(new int[] {X-B, move+1});
            }
            if(X+F <= N && !map[X+F]) {
                map[X+F] = true;
                q.offer(new int[] {X+F, move+1});
            }
        }

        System.out.println("BUG FOUND");
    }
}
