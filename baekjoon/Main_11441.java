package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken());

            sb.append(sum[j]-sum[i]).append("\n");
        }
        System.out.println(sb);
    }
}
