package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25602 {
    static int N, K, max;
    static int[] A;
    static int[][] R, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 캔의 종류
        K = Integer.parseInt(st.nextToken()); // K일
        max = 0;
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        M = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int cnt, int rc, int mc) {
        if(cnt == K) {
            max = Math.max(max, rc+mc);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(A[i] > 0) {
                A[i]--;
                for (int j = 0; j < N; j++) {
                    if(A[j] > 0) {
                        A[j]--;
                        dfs(cnt+1, rc+R[cnt][i], mc+M[cnt][j]);
                        A[j]++;
                    }
                }
                A[i]++;
            }
        }
    }
}
