package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12842 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[] t = new int[m+1]; // 사람별 먹는 시간
        for (int i = 1; i <= m; i++) {
            t[i] = Integer.parseInt(br.readLine());
        }

        int eat = n-s; // 먹힌 소보루 개수
        int time = 0;
        int idx = 0;

        while (eat > 0) {
            for (int i = 1; i <= m; i++) {
                if (time % t[i] == 0) {
                    eat--;
                    idx = i;
                    if (eat == 0) break;
                }
            }
            time++;
        }

        System.out.println(idx);

    }
}
