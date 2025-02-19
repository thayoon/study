package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> pos = new ArrayList<>(); // 양수
        List<Integer> neg = new ArrayList<>(); // 음수
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now>0) pos.add(now);
            else neg.add(Math.abs(now));
        }

        // 내림차순 정렬
        pos.sort(Collections.reverseOrder());
        neg.sort(Collections.reverseOrder());

        int cnt = 0;
        int max = 0; // 가장 먼 거리

        for (int i = 0; i < pos.size(); i+=M) {
            cnt += pos.get(i)*2;
            max = Math.max(max, pos.get(i));
        }
        for (int i = 0; i < neg.size(); i+=M) {
            cnt += neg.get(i)*2;
            max = Math.max(max, neg.get(i));
        }

        // 가장 먼 거리는 왕복할 필요 없음
        System.out.println(cnt - max);
    }
}
