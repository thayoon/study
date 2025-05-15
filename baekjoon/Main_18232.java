package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Integer>[] map = new List[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.offer(new int[] {S, 0});
        visited[S] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int X = now[0];
            int move = now[1];

            if(X == E) {
                time = move;
                break;
            }

            if(X-1 > 0 && !visited[X-1]) {
                visited[X-1] = true;
                q.offer(new int[] {X-1, move+1});
            }
            if(X+1 <= N && !visited[X+1]) {
                visited[X+1] = true;
                q.offer(new int[] {X+1, move+1});
            }
            for(int next : map[X]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, move+1});
                }
            }
        }

        System.out.println(time);
    }
}
