package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] item = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
            if(item[i] == C) ans = 1; // 1개 조합 가능
        }

        if(ans == 1) {
            System.out.println(1);
            return;
        }

        Arrays.sort(item);

        int left = 0;
        int right = N-1;

        while(left < right) {
            int w = item[left]+item[right];
            if (w < C) {
                // 최대 3개까지 선택 가능
                for (int i = left + 1; i < right; i++) {
                    w += item[i];
                    if (w == C) break;
                    w -= item[i];
                }
            }

            if(w == C) { // 무게 완성
                ans = 1;
                break;
            }
            if(w > C) { // 무게가 크다면
                right--;
            } else { // 작다면
                left++;
            }
        }
        // 무게 만족 O 1 : 무게 만족 X 0
        System.out.println(ans == 1 ? 1 : 0);
    }
}
