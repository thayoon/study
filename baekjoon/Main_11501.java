package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] days = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int max = 0;
            for (int i = N-1; i >= 0; i--) {
                if(days[i] > max) {
                    max = days[i];
                } else {
                    profit += max - days[i];
                }
            }
            sb.append(profit).append("\n");
        }

        System.out.println(sb);
    }
}
