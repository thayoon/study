package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int S = Integer.parseInt(st.nextToken()); // 찾고자 하는 부분합

        int len = 100001;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if(num >= S) { // S 이상의 값이 존재하면 1로 갱신
                len = 1;
            }
        }
        if(len == 1) { // 1인 경우 출력 후 종료
            System.out.println(1);
            return;
        }

        int left = 0; // 부분합 시작 index
        int right = 0; // 부분합 끝 index
        int sum = 0; // 현재 부분 합

        while(true) {
            if(sum >= S) {
                // 현재 부분합이 S보다 크거나 같다면
                len = Math.min(len, right-left); // 부분합 길이 갱신
                sum -= arr[left++]; // 부분합 빼기 (시작 인덱스 감소)
            } else if (right == N) {
                // 현재 부분합이 S보다 작고 끝 인덱스가 배열의 크기라면 while문 종료
                break;
            } else {
                // 현재 부분합이 S보다 작다면
                sum += arr[right++]; // 부분합 더하기 (끝 인덱스 증가)
            }
        }

        System.out.println(len == 100001 ? 0 : len);
    }
}
