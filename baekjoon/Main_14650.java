package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14650 {
    static int N, cnt;
    static int[] arr = {0, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        dfs(0, 0);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int num) {
        if (depth == N) {
            if (num % 3 == 0) cnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (depth == 0 && arr[i] == 0) continue;
            dfs(depth + 1, num * 10 + arr[i]);
        }
    }
}
