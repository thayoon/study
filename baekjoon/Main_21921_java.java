package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 블로그 시작 후 지난 일수
        int X = Integer.parseInt(st.nextToken());   // 연속 일
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken()); // 방문자 수 초기화
        }

        int max = 0;    // 가장 많이 들어온 방문자 수
        int days = 1;   // 가장 많이 들어온 방문자 수 기간 수
        int next = 0;   // 현재 슬라이딩 윈도우 값
        // 슬라이딩 윈도우 초기화
        for (int i = 0; i < X; i++) {
            next += visitors[i];
        }
        max = next;

        for (int i = X; i < N; i++) {
            int j = i-X;    // 이전 방문자 수
            next = next-visitors[j]+visitors[i]; // 다음 방문자 수
            if(next > max) {    // 가장 많이 방문자 수보다 크다면
                max = next; // max값 갱신
                days = 1;   // 기간 초기화
            } else if(next == max) {    // 가장 많이 방문자 수와 같다면
                days++; // 기간 추가
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        }else {
            System.out.println(max);   // X일 동안 가장 많이 들어온 방문자 수
            System.out.println(days);   // 기간이 몇개인지
        }
    }
}
