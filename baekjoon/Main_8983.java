package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 사대 수
        int N = Integer.parseInt(st.nextToken()); // 동물 수
        int L = Integer.parseInt(st.nextToken()); // 사정거리

        int[] px = new int[M]; // 사대 x 위치
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            px[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(px);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = M-1;
            while(left<=right) {
                int mid = (left+right)/2; // 사대 위치 찾기

                if(Math.abs(px[mid]-x)+y <= L) {
                    // 사정거리 안이라면 사냥 가능
                    cnt++;
                    break;
                }

                if(x < px[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }

        System.out.println(cnt);
    }
}
