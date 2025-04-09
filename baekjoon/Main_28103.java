package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(st.nextToken()); // 참가자 수
        int M = Integer.parseInt(st.nextToken()); // 상품 목록 개수
        long X = Long.parseLong(st.nextToken()); // 자금

        int[] a = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 사람에게 상품을 줘야하므로 가장 싼 상품을 미리 계산
        int min = a[M-1];
        X -= min*N;

        long[] cnt = new long[M];
        for (int i = 0; i < M; i++) {
            a[i] -= min; // 가장 싼 상품의 추가 비용으로 갱신
        }

        for (int i = 0; i < M-1; i++) {
            int price = a[i];
            if(price > 0) {
                long count = Math.min(X/price, N); // X로 구매 가능한 사람과 남은 인원 중 작은 값
                cnt[i] += count;
                N -= count;
                X -= count*price;
            }
        }
        cnt[M-1] = N; // 남은 인원은 가장 싼 상품

        for (long r : cnt) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }
}
