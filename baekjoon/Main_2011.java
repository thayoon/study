package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();

        int[] dp = new int[code.length()+1];
        if(code.charAt(0) == '0') {
            System.out.println(0);
        } else {
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= code.length(); i++) {
                int one = code.charAt(i-1) - '0';
                int two = (code.charAt(i-2)-'0')*10 + one;
                if(0 < one) {
                    dp[i] = (dp[i] + dp[i-1]) % 1000000;
                }
                if(10 <= two && two <= 26) {
                    dp[i] = (dp[i] + dp[i-2]) % 1000000;
                }
            }
            System.out.println(dp[code.length()]);
        }
    }
}
