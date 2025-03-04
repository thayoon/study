package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int[] days = new int[N];
        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, days[i]); // 하루 최대 소비 금액
            right += days[i]; // 총 사용 금액
        }

        int K = right;
        while(left <= right) {
            int mid = (left+right)/2;

            int cnt = 1; // 인출 횟수
            int money = mid; // 현재 인출한 돈
            for (int i = 0; i < N; i++) {
                if(money < days[i]) { // 인출
                    cnt++;
                    money = mid;
                }
                money -= days[i]; // 돈 사용
                if(cnt > M) break;
            }

            if(cnt > M) {
                // 인출 횟수가 많다면 최솟값 높이기
                left = mid+1;
            } else {
                K = mid;
                right = mid-1;
            }
        }

        System.out.println(K);
    }
}
