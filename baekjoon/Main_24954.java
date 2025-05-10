package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24954 {
    static int N, min;
    static int[] c;
    static List<int[]>[] p;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        visited = new boolean[N+1];
        c = new int[N+1];
        p = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            p[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 물약 번호
                int d = Integer.parseInt(st.nextToken()); // 할인 가격

                p[i].add(new int[] {a, d});
            }
        }

        dfs(0, 0, c);
        System.out.println(min);
    }

    public static void dfs(int cnt, int sum, int[] coin) {
        if(sum > min) return;

        if(cnt == N) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int[] next = Arrays.copyOf(coin, N+1);
                for(int[] s : p[i]) {
                    next[s[0]] = Math.max(1, next[s[0]]-s[1]);
                }
                dfs(cnt+1, sum+next[i], next);
                visited[i] = false;
            }
        }
    }
}
