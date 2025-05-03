package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18429 {
    static int N, K, cnt;
    static int[] kit;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;

        dfs(0, 500);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int sum) {
        if(sum < 500) return;

        if(depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, sum+kit[i]-K);
                visited[i] = false;
            }
        }
    }
}
