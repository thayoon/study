package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] vc = new int[K][2]; // 선호도, 도수 레벨
        long left = Integer.MAX_VALUE; // 도수 레벨 최솟값
        long right = 0; // 도수 레벨 최댓값
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            vc[i][0] = Integer.parseInt(st.nextToken()); // 선호도
            vc[i][1] = Integer.parseInt(st.nextToken()); // 도수 레벨

            left = Math.min(left, vc[i][1]);
            right = Math.max(right, vc[i][1]);
        }

        Arrays.sort(vc, (o1, o2) -> {
            if(o1[0] == o2[0]) { // 같은 선호도라면 도수 레벨 오름차순 정렬
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0]; // 선호도 내림차순 정렬
        });

        long level = -1; // 간 레벨
        while(left <= right) {
            long mid = (left+right)/2; // 현재 설정 간 레벨

            int day = 0; // 맥주 축제 출석일
            long prefer = 0; // 선호도 합
            for (int i = 0; i < K; i++) {
                if(mid >= vc[i][1]) { // 도수가 간 레벨 이하라면 섭취
                    day++; // 출석일 갱신
                    prefer += vc[i][0]; // 선호도 총 합 갱신
                }
                if(day == N) break; // 모든 축제에 참석했다면 반복문 종료
            }

            if(day == N && prefer >= M) { // 모든 축제에 참여하고 선호도 총 합이 목표 선호도를 넘었다면
                right = mid-1; // 간 레벨 낮추기
                level = mid; // 현재 간 레벨 갱신
            } else {
                left = mid+1; // 간 레벨 높이기
            }
        }

        System.out.println(level);
    }
}
