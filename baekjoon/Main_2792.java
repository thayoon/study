package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 1_000_000_000;

        int min = 0;
        while(left <= right) {
            int mid = (left+right)/2;

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                cnt += arr[i]/mid;

                if(arr[i] % mid != 0) {
                    cnt++;
                }

                if(cnt > N) break;
            }

            if(cnt > N) {
                left = mid+1;
            } else {
                min = mid;
                right = mid-1;
            }
        }

        System.out.println(min);
    }
}
