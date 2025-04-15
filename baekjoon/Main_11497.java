package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int[] sorting = new int[N];
            int left = 0;
            int right = N-1;
            for (int i = 0; i < N; i++) {
                if (i%2 == 0) {
                    sorting[left++] = arr[i];
                } else {
                    sorting[right--] = arr[i];
                }
            }

            int min = 0;
            for (int i = 0; i < N; i++) {
                int diff = Math.abs(sorting[i] - sorting[(i+1)%N]);
                min = Math.max(min, diff);
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
