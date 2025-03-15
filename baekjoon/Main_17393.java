package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st1.nextToken());
            B[i] = Long.parseLong(st2.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N-1;

            // A[i] 이하인 B의 최대 인덱스 찾기
            while(left <= right) {
                int mid = (left+right) / 2;
                if(B[mid] <= A[i]) left = mid+1;
                else right = mid-1;
            }
            sb.append(right - i).append(" ");
        }
        sb.append(0); // 마지막 칸은 칠할 수 없음
        System.out.println(sb);
    }
}
