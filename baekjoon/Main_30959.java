package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30959 {
    static int N, M, single, acc;
    static int[] ans;
    static int[][] models;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 모델 수
        M = Integer.parseInt(st.nextToken()); // 예측 항목 수
        ans = new int[M];
        single = 0; // 단일 모델 정확도
        acc = 0; // 하드 보팅 앙상블 정확도
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        models = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int precision = 0; // i번째 모델의 정답 정밀도
            for (int j = 0; j < M; j++) {
                models[i][j] = Integer.parseInt(st.nextToken());
                if(models[i][j] == ans[j]) precision++;
            }

            single = Math.max(single, precision);
        }

        // 하드 보팅 앙상블
        for (int i = 3; i <= N; i += 2) {
            ensemble(i, 0, 0, new int[i]);
        }

        System.out.println(single < acc ? 1 : 0);
    }

    public static void ensemble(int r, int cnt, int start, int[] visited) {
        if(single < acc) return;
        if(cnt == r) {
            // 하드 보팅 앙상블
            int[] ens = new int[M];
            for (int i = 0; i < M; i++) {
                int[] pre = new int[2];
                for (int j = 0; j < r; j++) {
                    pre[models[visited[j]][i]]++;
                }

                ens[i] = pre[0] > pre[1] ? 0 : 1;
            }

            int now = 0;
            for (int i = 0; i < M; i++) {
                if(ens[i] == ans[i]) now++;
            }

            acc = Math.max(acc, now);

            return;
        }

        for (int i = start; i < N; i++) {
            visited[cnt] = i;
            ensemble(r, cnt+1, i+1, visited);
        }
    }
}
