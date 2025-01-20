package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = sum[K-1];
        for (int i = K; i < N; i++) {
            int j = sum[i]-sum[i-K];
            if(j > max) max = j;
        }

        System.out.println(max);
    }
}
