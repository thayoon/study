package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long left = 0;
        long right = arr[N-1];

        long hight = 0;
        while(left <= right) {
            long mid = (left+right) / 2; // 현재 절단기 높이

            long tree = 0; // 현재 잘린 높이
            for (int i = 0; i < N; i++) {
                // 절단기 높이보다 현재 나무가 높다면 절단
                if(arr[i]>mid) tree += arr[i]-mid;
                if(tree>=M) break;
            }

            if(tree >= M) { // 잘린 높이가 적어도 M보다 크다면 현재 절단 높이 갱신 및 절단기 높이 증가
                hight = mid;
                left = mid+1;
            } else { // 절단기 높이 감소
                right = mid-1;
            }
        }

        System.out.println(hight);
    }
}
