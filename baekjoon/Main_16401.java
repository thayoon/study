package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cookies = new int[N];
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, cookies[i]);
        }

        int left = 1;

        int len = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            int cnt = 0;
            for(int cookie : cookies) {
                cnt += cookie/mid; // mid로 나눴을 때 몇 개 나오는지 계산
                if(cnt >= M) break;
            }

            if(cnt >= M) {
                len = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(len);
    }
}
