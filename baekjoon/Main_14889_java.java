package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {
    static int N, status[][], min;
    static boolean team[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());    // 인원 수
        status = new int[N][N]; // 능력치 배열
        team = new boolean[N];  // 조합으로 뽑은 팀 배열
        min = Integer.MAX_VALUE;    // 능력치 차이 최솟값

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // todo: N/2 서로 다른 팀원 뽑기
        combi(0, 0);

        System.out.println(min);
    }

    private static void combi(int cnt, int start) {
        if(cnt == N/2) {
            // todo: 팀 능력치 차이 최솟값 구하기
            int s = 0;  // 스타트 팀
            int l = 0;  // 링크 팀
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if(team[i] && team[j]) {
                        s += status[i][j];
                    }
                    if(!team[i] && !team[j]) {
                        l += status[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(s-l));
            return;
        }
        for (int i = start; i < N; i++) {
            team[i] = true;
            combi(cnt+1, i+1);
            team[i] = false;
        }
    }
}
