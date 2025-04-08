package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            num[p]++;
        }
        int max = 0;

        // (0,3), (1,2) => 3
        int cnt = Math.min(num[0], num[3]);
        max += cnt*3;
        num[0] -= cnt;
        num[3] -= cnt;
        int num1 = num[0] == 0 && num[3] == 0 ? -1 : num[0] > 0 ? 0 : 3;

        cnt = Math.min(num[1], num[2]);
        max += cnt*3;
        num[1] -= cnt;
        num[2] -= cnt;
        int num2 = num[1] == 0 && num[2] == 0 ? -1 : num[1] > 0 ? 1 : 2;

        if(num1 == -1 || num2 == -1) {
            System.out.println(max);
        } else {
            max += Math.min(num[num1], num[num2])*(num1^num2);
            System.out.println(max);
        }

    }
}
