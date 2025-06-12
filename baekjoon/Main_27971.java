package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_27971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] map = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            Arrays.fill(map, L, R+1, true);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        map[0] = true;


        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int move = now[1];

            if(cur == N) {
                System.out.println(move);
                return;
            }

            for(int next : new int[] {cur+A, cur+B}) {
                if(next <= N && !map[next]) {
                    map[next] = true;
                    q.offer(new int[] {next, move+1});
                }
            }
        }

        System.out.println(-1);
    }
}
