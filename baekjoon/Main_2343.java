package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
        }

        int right = 100000*10000;
        int min = 0;
        while(left <= right) {
            int mid = (left+right)/2;

            int cnt = 1;
            int len = 0;
            for (int i = 0; i < N; i++) {
                if(len + arr[i] <= mid) {
                    len += arr[i];
                } else {
                    cnt++;
                    len = arr[i];
                }

                if(cnt > M) break;
            }

            if(cnt > M) {
                left = mid+1;
            } else {
                min = mid;
                right = mid-1;
            }
        }

        System.out.println(min);
    }
}
