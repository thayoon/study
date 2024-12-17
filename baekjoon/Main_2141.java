package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        long A = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken()); // X
            map[i][1] = Integer.parseInt(st.nextToken()); // A
            A += map[i][1];
        }

        Arrays.sort(map, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        long mid = (A+1)/2;
        long sum = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][1];
            if(sum >= mid) {
                ans = map[i][0];
                break;
            }
        }

        System.out.println(ans);
    }
}
