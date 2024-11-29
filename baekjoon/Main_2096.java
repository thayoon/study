package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N][3]; // 최대 점수 dp
        int[][] min = new int[N][3]; // 최소 점수 dp
        for (int i = 0; i < 3; i++) {
            max[0][i] = map[0][i];
            min[0][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            // 0번 인덱스 선택 가능 - 0, 1
            // 1번 인덱스 선택 가능 - 0, 1, 2
            // 2번 인덱스 선택 가능 - 1, 2
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
            max[i][1] = Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2])) + map[i][1]; 
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + map[i][2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
            min[i][1] = Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2])) + map[i][1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + map[i][2];
        }

        System.out.println(Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2]))+" "+Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2])));
    }
}
