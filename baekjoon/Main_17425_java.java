package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17425 {
    static int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // fx[2] = 1의 약수 합(1) + 2의 약수 합(1+2)
        long[] fx = new long[MAX];    // 약수들의 합
        // gx[4] = fx[1] + fx[2] + fx[3] + fx[4]
        long[] gx = new long[MAX];

        Arrays.fill(fx, 1); // 모든 수의 약수 1을 가짐
        // 에라토스테네스의 체로 약수의 합 f(x) 구하기
        for (int i = 2; i < MAX; i++) {
            // i의 배수에 대해 i를 약수로 추가해 약수의 합 갱신
            for (int j = 1; i*j < MAX; j++) {
                fx[i*j] += i;
            }
        }

        // fx 누적합으로 g(x) 구하기
        for (int i = 1; i < MAX; i++) {
            gx[i] = gx[i-1] + fx[i];
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(gx[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
