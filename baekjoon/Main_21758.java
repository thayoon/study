package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] honey = new int[N+1];
        int[] sum = new int[N+1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+honey[i];
        }

        // 벌통이 오른쪽 끝에 있는 경우: 벌(fix)-벌(move)-벌통
        int leftHoney = sum[N] - honey[1]; // fix
        for (int i = 2; i < N; i++) {
            int moveHoney = sum[N] - sum[i]; // move
            int now = leftHoney - honey[i] + moveHoney;
            max = Math.max(now, max);
        }

        // 벌통이 왼쪽 끝에 있는 경우: 벌통-벌(move)-벌(fix)
        int rightHoney = sum[N-1]; // fix
        for (int i = 2; i < N; i++) {
            int moveHoney = sum[i-1]; // move
            int now = rightHoney - honey[i] + moveHoney;
            max = Math.max(now, max);
        }

        // 벌통이 가운데 있는 경우: 벌-벌통(move)-벌
        for (int i = 2; i < N; i++) {
            // 벌-벌통: sum[i] - honey[1]
            // 벌통-벌: sum[N-1] - sum[i-1]
            int now = sum[i] - honey[1] + sum[N-1] - sum[i-1];
            max = Math.max(now, max);
        }
        System.out.println(max);
    }
}
