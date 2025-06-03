package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] = g;
        }

        long sum = 0;
        int window = 2*K+1;
        for (int i = 0; i < window && i <= 1000000; i++) {
            sum += ice[i];
        }

        long max = sum;
        for (int i = 1; i <= 1000001 - window; i++) {
            sum -= ice[i-1];
            sum += ice[i+window-1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
