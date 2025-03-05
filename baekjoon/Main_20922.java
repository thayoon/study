package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int max = 0;
        int left = 0;
        for (int right = 0; right < N; right++) {
            cnt[arr[right]]++;

            while(cnt[arr[right]] > K) {
                cnt[arr[left]]--;
                left++;
            }

            max = Math.max(max, right-left+1);
        }

        System.out.println(max);
    }
}
