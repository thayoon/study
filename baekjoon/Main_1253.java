package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 수의 개수
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while (left < right) {
                // 현재 인덱스와 탐색 인덱스가 같다면 다음 수
                if(i == left) {
                    left++;
                    continue;
                } else if (i == right) {
                    right--;
                    continue;
                }

                int now = num[left]+num[right]; // 더한 수

                if(now == num[i]) { // 더한 수가 현재 탐색 수와 같다면 좋다
                    ans++;
                    break;
                } else if (now > num[i]) { // 크다면 오른쪽 인덱스 감소
                    right--;
                } else { // 작다면 왼쪽 인덱스 증가
                    left++;
                }
            }
        }

        System.out.println(ans);

    }
}
