package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sb.append('0'); // 심판 배치 초기화
        }

        int left = 0;
        int right = N;
        String ans = "";

        while(left <= right) {
            int mid = (left+right)/2; // 심판 사이의 최대 거리 찾기

            sb.setCharAt(0, '1'); // 첫 번째 심판 배치
            for (int i = 1; i < K; i++) {
                sb.setCharAt(i, '0'); // 나머지 위치 초기화
            }
            int cnt = 1; // 첫 번째 심판 배치
            int last = 0; // 마지막으로 배치된 심판 위치

            for (int i = 1; i < K; i++) {
                if(arr[i]-arr[last] >= mid) { // 이전 심판과의 거리가 mid 이상이면 배치
                    sb.setCharAt(i, '1');
                    last = i; // 마지막 심판 위치 갱신
                    cnt++; // 심판 배치 수 증가
                    if(cnt == M) break;
                }
            }

            if(cnt == M) { // M명 배치에 성공하면 더 큰 mid 탐색
                ans = sb.toString(); // 현재 배치 결과 갱신
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(ans);
    }
}
