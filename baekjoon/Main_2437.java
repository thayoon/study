package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] W = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(W);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(sum+1 >= W[i]) {
                // 현재까지 더한 숫자 + 1 (연속된 값)이 현재 무게보다 크거나 같다면
                // 범위 안 숫자를 측정할 수 있음
                sum += W[i];
            } else {
                break;
            }
        }

        if(W[0] > 1) {
            System.out.println(1);
        }else {
            System.out.println(sum + 1);
        }
    }
}
