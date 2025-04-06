package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_24464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mod = 1_000_000_007;

        int[] prev = new int[5];
        int[] cur = new int[5];

        // 첫날에는 모든 식단 가능
        Arrays.fill(prev, 1);

        for (int i = 1; i < N; i++) { // day
            Arrays.fill(cur, 0);

            for (int j = 0; j < 5; j++) { // yesterday
                for (int k = 0; k < 5; k++) { // today
                    if(j == 0 && k != 0) { // 어제 굶었다면 오늘은 식당
                        cur[k] = (cur[k] + prev[0]) % mod;
                    } else if (j != 0 && (k == 0 || Math.abs(k - j) > 1)) { // 어제 식당이었다면 굶기 또는 다른 식당
                            cur[k] = (cur[k] + prev[j]) % mod;
                    }
                }
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        long cnt = 0;
        for (int i = 0; i < 5; i++) {
            cnt = (cnt + prev[i])%mod;
        }

        System.out.println(cnt);
    }
}
