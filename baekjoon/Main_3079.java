package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(T);

        long low = 1;
        long high = (long) T[N - 1] * M;
        long ans = high;
        while(low<=high) {
            long mid = (low+high)/2;
            
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid/T[i];
                if(cnt>=M) break;
            }

            if(cnt >= M) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        System.out.println(ans);
    }
}
