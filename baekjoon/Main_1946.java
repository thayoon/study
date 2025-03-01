package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] score = new int[N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken()); // 서류
                int I = Integer.parseInt(st.nextToken()); // 면접
                score[R] = I; // 서류 성적 기준으로 정렬
            }
            int cnt = 1; // 서류 1등 합격
            int grade = score[1]; // 면접 성적 기준
            for (int i = 2; i <= N; i++) {
                if(grade>score[i]) { // 현재 면접 성적보다 높다면 합격
                    cnt++;
                    grade = score[i]; // 면접 성적 기준 갱신
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
