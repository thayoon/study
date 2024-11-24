package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());   // 수열 크기
        int[] arr = new int[N];
        int[] dp = new int[N];
        int len = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }

            len = Math.max(len, dp[i]);
        }

        System.out.println(len);
    }
}
