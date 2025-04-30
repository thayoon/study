package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int left = 0;
        while(left <= right) {
            int mid = (left+right)/2;

            long budget = 0;
            for (int i = 0; i < N; i++) {
                budget += Math.min(arr[i], mid);

                if(budget > M) break;
            }

            if(budget > M) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(right);
    }
}
