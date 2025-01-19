package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] remainder = new long[M];
        long sum = 0;
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            if(sum == 0) cnt++;
            cnt += remainder[(int)sum]; // 조합 만들기
            remainder[(int)sum]++;
        }

//        for (int i = 0; i < M; i++) { // 조합 만들기 remainder[i]C2
//            if(remainder[i] > 1) cnt += (remainder[i] * (remainder[i]-1)) / 2;
//        }

        System.out.println(cnt);

    }
}
