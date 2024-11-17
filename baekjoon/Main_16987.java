package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {
    static int N, max;
    static int[][] egg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine()); // 계란 수
        egg = new int[N][2];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }
        backtrack(0);

        System.out.println(max);
    }

    public static void backtrack(int index) {
        if(index == N) {
            // 모든 계란을 다 들었다면 깨진 계란 총 합 구하기
            int now = 0;
            for (int i = 0; i < N; i++) {
                if (egg[i][0] <= 0) now++;
            }
            max = Math.max(max, now); // 최대값 갱신
            return;
        }

        if(egg[index][0] <= 0) {
            // 왼손에 든 계란이 이미 깨진 경우 다음 계란으로 넘어감
            backtrack(index + 1);
            return;
        }

        boolean broken = false;
        for (int i = 0; i < N; i++) {
            if(i != index && egg[i][0] > 0) { // 오른손 계란(i)이 깨지지 않은 경우
                broken = true;

                // 계란으로 계란치기
                egg[index][0] -= egg[i][1]; // 왼손 계란 내구도 감소
                egg[i][0] -= egg[index][1]; // 오른손 계란 내구도 감소

                backtrack(index + 1); // 다음 계란으로 이동

                // backtracking
                egg[index][0] += egg[i][1];
                egg[i][0] += egg[index][1];
            }
        }

        if(!broken) {
            // 충돌할 계란이 없는 경우 다음 계란으로 이동
            backtrack(index + 1);
        }
    }
}
