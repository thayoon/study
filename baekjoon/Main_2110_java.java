package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());    // 집 수
        int C = Integer.parseInt(st.nextToken());   // 공유기 수
        int[] arr = new int[N]; // 집 좌표

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int high = arr[N-1]-arr[0]+1; // 최소 거리 최댓값
        int low = 1; // 최소 거리 최솟값

        while(low < high) {
            int mid = (high+low)/2;

            int cnt = 1; // mid 거리 내 설치 가능 공유기 수, 첫 번째 집은 무조건 설치한다 가정
            int loc = arr[0]; // 마지막 설치 위치

            for (int i = 1; i < N; i++) {
                if(arr[i] - loc >= mid) { // mid 거리보다 크거나 같다면, 마지막 설치 위치 갱신
                    cnt++;
                    loc = arr[i];
                }
                if(cnt>=C) break;
            }

            if(cnt < C) { // 공유기 설치 수가 C개보다 작다면 최댓값 갱신
                high = mid;
            }else {
                low = mid+1;
            }
        }

        System.out.println(low-1);

    }
}
