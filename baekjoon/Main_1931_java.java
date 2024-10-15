package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        // 회의 끝나는 시간 기준으로 오름차순 정렬
        Arrays.sort(meeting, (o1, o2)-> {
            if(o1[1] == o2[1]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });

        int max = 0;    // 선택 가능 회의 수
        int end = 0;    // 현재 회의 종료 시각
        for (int i = 0; i < N; i++) {
            // i번째 회의 시작 시각이 회의 종료 시각보다 같거나 크다면 선택
            if(end <= meeting[i][0]) {
                max++;
                end = meeting[i][1];    // 종료 시각 갱신
            }
        }
        System.out.println(max);
    }
}
