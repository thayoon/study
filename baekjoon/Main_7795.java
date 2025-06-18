package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int left = 0;
                int right = M-1;
                int idx = 0;

                while(left <= right) {
                    int mid = (left+right)/2;
                    if(B[mid] < A[i]) {
                        left = mid+1;
                        idx = mid+1;
                    } else {
                        right = mid-1;
                    }
                }

                cnt += idx;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
