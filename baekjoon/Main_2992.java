package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2992 {
    static int X, N, min;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        X = Integer.parseInt(str);
        N = str.length();
        arr = new int[N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i)-'0';
        }

        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void dfs(int cnt, int sum) {
        if(sum > min) return;

        if(cnt == N) {
            if(sum > X) {
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(cnt+1, sum*10+arr[i]);
                visited[i] = false;
            }
        }
    }
}
