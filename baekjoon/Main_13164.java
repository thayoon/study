package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] h = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[] dif = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            dif[i] = h[i+1] - h[i];
        }
        Arrays.sort(dif);

        int min = 0;
        for (int i = 0; i < N-K; i++) {
            min += dif[i];
        }

        System.out.println(min);
    }
}
