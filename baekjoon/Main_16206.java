package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> cake = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cake.add(Integer.parseInt(st.nextToken()));
        }
        cake.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                boolean isO1 = o1 % 10 == 0;
                boolean isO2 = o2 % 10 == 0;

                if (isO1 && isO2) return o1 - o2; // 10의 배수인 경우 오름차순
                if (isO1) return -1; // 10의 배수 오름차순
                if (isO2) return 1;
                return o2 - o1; // 10의 배수가 아닌 경우 내림차순
            }
        });
        int cnt = 0;
        for (int cur : cake) {
            if(M == 0) break;
            while(cur > 10 && M > 0) {
                cur -= 10;
                cnt++;
                M--;
            }
            if(cur == 10) cnt++;
        }

        System.out.println(cnt);
    }
}
