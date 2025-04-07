package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        long left = 1;
        long right = 1_000_000_000;
        long k = 0;
        while(left <= right) {
            long mid = (left+right)/2;

            boolean work = true;
            for (int i = 0; i < n; i++) {
                if((long)(i+1)*mid > A[i]) {
                    work = false;
                    break;
                }
            }

            if(work) {
                k = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(k);

    }
}
