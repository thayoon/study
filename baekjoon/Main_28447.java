package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28447 {
    static int N, K, sum;
    static int[][] C;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sum = Integer.MIN_VALUE;
        C = new int[N][N];
        temp = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(K == 1) {
            System.out.println(0);
            return;
        }
        comb(0, 0);
        System.out.println(sum);
    }

    public static void comb(int cnt, int start) {
        if(cnt == K) {
            sum = Math.max(sum, sumc());
            return;
        }
        for (int i = start; i < N; i++) {
            temp[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    public static int sumc() {
        int sigma = 0;
        for (int i = 0; i < K; i++) {
            int ni = temp[i];
            for (int j = i+1; j < K; j++) {
                int nj = temp[j];
                sigma += C[ni][nj];
            }
        }
        return sigma;
    }
}
