package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        int max = now;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            now = Math.max(now+num, num);
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}
