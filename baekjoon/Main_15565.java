package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> lion = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now == 1) {
                lion.add(i);
            }
        }

        int min = 987654321;
        for (int i = 0; i <= lion.size()-K; i++) {
            int left = lion.get(i);
            int right = lion.get(i+K-1);

            min = Math.min(min, right-left+1);
        }

        System.out.println(min == 987654321 ? -1 : min);
    }
}
