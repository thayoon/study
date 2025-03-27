package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1455 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--) {
                if(map[i][j] == 1) {
                    flip(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void flip(int a, int b) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                map[i][j] ^= 1;
            }
        }
    }
}
