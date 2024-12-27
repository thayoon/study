package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001];
        dp[1] = true; // 상근이가 이긴 경우
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i <= N; i++) {
            if(!dp[i-1] || !dp[i-3] || !dp[i-4]) { // 창근이가 이긴 경우가 있다면
                dp[i] = true; // 다음은 상근이 승
            }
        }

        System.out.println(dp[N] ? "SK" : "CY");
//        if(N%7 == 0 || N%7 == 2) {
//            // 패/승/패/승/승/승/승
//            System.out.println("CY");
//        } else {
//            System.out.println("SK");
//        }

    }
}
