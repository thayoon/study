package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N*N];
        int[] CD = new int[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i]+B[j];
                CD[idx] = C[i]+D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long ans = 0;
        int left = 0;
        int right = N*N-1;
        while(left < N*N && right >= 0) {
            int nab = AB[left];
            int ncd = CD[right];
            int mid = nab+ncd;
            if(mid < 0){
                left++;
            } else if(mid > 0) {
                right--;
            } else {
                // 0인 경우, 중복된 해당 수 찾기
                long sab = 0;
                long scd = 0;
                while(left<N*N && nab == AB[left]) {
                    left++;
                    sab++;
                }
                while(right>=0 && ncd == CD[right]) {
                    right--;
                    scd++;
                }
                ans += sab*scd;
            }
        }

        System.out.println(ans);
    }
}
